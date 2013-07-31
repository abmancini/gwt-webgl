package com.jooink.experiments.gwtwebgl.client.tests.julia;

import java.util.Arrays;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.jooink.experiments.gwtwebgl.client.Test;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class Julia  extends Test {



	private static final  float[][] baseCorners = {
		{ 1.7f,  1.2f},
		{ -1.7f,  1.2f},
		{ 1.7f, -1.2f},
		{-1.7f, -1.2f},
	};

	@Override
	public String getName() {
		return "Julia";
	}

	@Override
	public void execute(HasWidgets.ForIsWidget cont, EventBus bus) {


		Canvas canvas = Canvas.createIfSupported();

		cont.clear();
		cont.add(canvas);

		final WebGLRenderingContext ctx = WebGL.getContext(canvas);

		CanvasElement canvasElement =  canvas.getCanvasElement();

		canvasElement.setWidth(640);
		canvasElement.setHeight(480);

		ctx.viewport(0, 0, 640, 480);




		//initShaders()
		//	    var fragmentShader = getShader(gl, "shader-fs");
		//	    var vertexShader = getShader(gl, "shader-vs");
		//	
		//	    shaderProgram = gl.createProgram();
		//	    gl.attachShader(shaderProgram, vertexShader);
		//	    gl.attachShader(shaderProgram, fragmentShader);
		//	    gl.linkProgram(shaderProgram);
		//	
		//	    if (!gl.getProgramParameter(shaderProgram, gl.LINK_STATUS))
		//	    {
		//	      alert("Could not initialise shaders");
		//	    }
		//	
		//	    gl.useProgram(shaderProgram);

		WebGLShader vs  =
				Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader().getText(), ctx);

		WebGLShader fs =
				Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER,Shaders.INSTANCE.fragmentShader().getText(), ctx);

		WebGLProgram program =
				Utils.createAndUseProgram(Arrays.asList(vs,fs), ctx);





		int aVertexPosition = ctx.getAttribLocation(program, "aVertexPosition");
		ctx.enableVertexAttribArray(aVertexPosition);

		int aPlotPosition = ctx.getAttribLocation(program, "aPlotPosition");
		ctx.enableVertexAttribArray(aPlotPosition);

		int aJuliaPosition = ctx.getAttribLocation(program, "aJuliaPosition");
		ctx.enableVertexAttribArray(aJuliaPosition);

		ctx.clearColor(0.0f, 0.0f, 0.0f, 1.0f);

		ctx.clearDepth(1.0f);

		//initBuffers();
		WebGLBuffer vertexPositionBuffer = ctx.createBuffer();
		ctx.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);
		float[] vertices = {
				1.0f,  1.0f,
				-1.0f,  1.0f,
				1.0f, -1.0f,
				-1.0f, -1.0f,
		};
		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Utils.Float32ArrayfromFloatArray(vertices), WebGLRenderingContext.STATIC_DRAW);
		ctx.vertexAttribPointer(aVertexPosition, 2, WebGLRenderingContext.FLOAT, false, 0, 0);



		WebGLBuffer plotPositionBuffer = ctx.createBuffer();
		ctx.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, plotPositionBuffer);


		float[] corners = new float[baseCorners.length*2];
		for (int i = 0 ; i< baseCorners.length; i++) {
			corners[2*i] = baseCorners[i][0];   // x
			corners[2*i+1] = baseCorners[i][1]; // y
		}


		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Utils.Float32ArrayfromFloatArray(corners), WebGLRenderingContext.STATIC_DRAW);
		ctx.vertexAttribPointer(aPlotPosition, 2, WebGLRenderingContext.FLOAT, false, 0, 0);


		WebGLBuffer juliaPositionBuffer = ctx.createBuffer();
		ctx.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, juliaPositionBuffer);
		ctx.vertexAttribPointer(aJuliaPosition, 2, WebGLRenderingContext.FLOAT, false, 0, 0);



		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
			float t = 0;
			@Override
			public boolean execute() {
				drawScene(ctx,t);

				t += 0.05;
				if (t > Math.PI * 200) {
					t -= Math.PI * 200;
				}
				return true;
			}
		}, 50);


	}


	public void drawScene(WebGLRenderingContext ctx,float t) {

		//System.err.println("drawing for t=" + t);
		float[] corners = new float[baseCorners.length*2];
		for (int i = 0 ; i< baseCorners.length; i++) {
			float tp = (float)(t + Math.sin(t * 0.27 + i * Math.PI / 2) * (Math.sin(t * 0.55) * 0.4 + 0.4));
			corners[2*i] = ((float)Math.sin(tp * 0.7));
			corners[2*i+1] = ((float)Math.sin(tp));
		}


		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Utils.Float32ArrayfromFloatArray(corners), WebGLRenderingContext.STATIC_DRAW);

		ctx.drawArrays(WebGLRenderingContext.TRIANGLE_STRIP, 0, 4);
	}


	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}


}
