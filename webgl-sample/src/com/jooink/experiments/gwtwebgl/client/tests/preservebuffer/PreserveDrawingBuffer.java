package com.jooink.experiments.gwtwebgl.client.tests.preservebuffer;

import java.util.Arrays;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.typedarrays.client.Float32ArrayNative;
import com.google.gwt.typedarrays.client.Uint16ArrayNative;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Uint16Array;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLContextAttributes;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.html.WebGLUniformLocation;
import com.jooink.experiments.gwtwebgl.client.Test;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class PreserveDrawingBuffer extends Test implements MouseMoveHandler  {

	
	
	
	@Override
	public String getName() {
		return "PreserveDrawingBuffer";
	}

	
	private WebGLRenderingContext ctx;
	private WebGLUniformLocation offsetLoc;

	@Override
	public void execute(ForIsWidget cont, EventBus bus) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);
		final SimplePanel canvasCont = new SimplePanel(); 
		cont.clear();
		cont.add(hp);
		hp.add(canvasCont);
		ToggleButton tb = new ToggleButton("DO NOT PreserveBuffer","PreserveBuffer");
		
		hp.add(tb);
		
		tb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				play(canvasCont,event.getValue());
			}
		});
		
		tb.setValue(true,true);
		
	}


private void play(SimplePanel canvasCont, boolean preserveBuffer) {
	
	//Window.alert("playing: " + preserveBuffer);

	final Canvas canvas = Canvas.createIfSupported();
	canvasCont.setWidget(canvas);
	
	canvas.addMouseMoveHandler(this);

	WebGLContextAttributes attributes = WebGL.createAttributes();
	attributes.setPreserveDrawingBuffer(preserveBuffer);
	
	ctx  = WebGL.getContext(canvas,attributes);
		
	
	CanvasElement canvasElement =  canvas.getCanvasElement();

	
	canvasElement.setWidth(640);
	canvasElement.setHeight(480);

	ctx.viewport(0, 0, 640, 480);


	WebGLShader vs  =
			Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader().getText(), ctx);

	WebGLShader fs =
			Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER,Shaders.INSTANCE.fragmentShader().getText(), ctx);

	WebGLProgram program =
			Utils.createAndUseProgram(Arrays.asList(vs,fs), ctx);


	int positionLoc = ctx.getAttribLocation(program, "v_position");
	offsetLoc = ctx.getUniformLocation(program, "u_offset");

	int res = 1;
	setupQuad(ctx, res, positionLoc);

}
	
	

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		
		
		float mx = event.getX();
		float my = event.getY();

		//System.err.println("finring at: " + mx + " " + my );

		float x = mx /  (640) * 2 - 1;
		float y = my / (480) * -2 + 1;  // flip y

		//System.err.println("i.e. at: " + x + " " + y );

		drawBrush(x, y);

	}




	private void drawBrush(float x, float y) {
		int res =1;
		
		ctx.uniform2f(offsetLoc, x, y);

		ctx.drawElements(WebGLRenderingContext.TRIANGLES, res * res * 6, WebGLRenderingContext.UNSIGNED_SHORT, 0);

	}



	private void setupQuad(WebGLRenderingContext gl, int gridRes, int positionLoc) {
		float scale = 0.05f;

		int vertsAcross = gridRes + 1;
		int numVerts = vertsAcross * vertsAcross;

		Float32ArrayNative positions = Float32ArrayNative.create(numVerts * 2);
		Uint16ArrayNative indices = Uint16ArrayNative.create(6 * gridRes * gridRes);

		int poffset = 0;

		for (int zz = 0; zz <= gridRes; ++zz) {
			for (int xx = 0; xx <= gridRes; ++xx) {
				int u = xx / gridRes;
				int v = zz / gridRes;
				positions.set(poffset + 0,(-1 + 2 * u) * scale);
				positions.set(poffset + 1, (-1 + 2 * v) * scale);
				poffset += 2;
			}
		}

		int tbase = 0;
		for (int zz = 0; zz < gridRes; ++zz) {
			int index = zz * vertsAcross;
			for (int xx = 0; xx < gridRes; ++xx) {
				indices.set(tbase + 0,index + 0);
				indices.set(tbase + 1,index + 1);
				indices.set(tbase + 2,index + vertsAcross);
				indices.set(tbase + 3,index + vertsAcross);
				indices.set(tbase + 4,index + 1);
				indices.set(tbase + 5,index + vertsAcross + 1);
				index += 1;
				tbase += 6;
			}
		}

		
		makeBuffer(positions, WebGLRenderingContext.ARRAY_BUFFER, 2, positionLoc);
		makeBuffer(indices, WebGLRenderingContext.ELEMENT_ARRAY_BUFFER);
		
		
	}

	  private WebGLBuffer makeBuffer(Float32Array data, int type, int size, int loc) {
		     WebGLBuffer buf = ctx.createBuffer();
		    ctx.bindBuffer(type, buf);
		    ctx.bufferData(type, data, WebGLRenderingContext.STATIC_DRAW);
		    if (type == WebGLRenderingContext.ARRAY_BUFFER) {
		      ctx.enableVertexAttribArray(loc);
		      ctx.vertexAttribPointer(loc, size, WebGLRenderingContext.FLOAT, false, 0, 0);
		    }
		    return buf;
	}
	  
	  private WebGLBuffer makeBuffer(Uint16Array data,int type) {
		     WebGLBuffer buf = ctx.createBuffer();
		    ctx.bindBuffer(type, buf);
		    ctx.bufferData(type, data, WebGLRenderingContext.STATIC_DRAW);
		    return buf;
	}


	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}



}
