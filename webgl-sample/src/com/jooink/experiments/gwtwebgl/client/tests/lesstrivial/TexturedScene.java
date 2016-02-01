package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;



import java.util.Arrays;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.html.WebGLTexture;
import com.googlecode.gwtwebgl.html.WebGLUniformLocation;
import com.jooink.experiments.gwtwebgl.client.Matrices;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class TexturedScene extends Scene {

	private WebGLProgram program;
	private int w,h;
	private WebGLUniformLocation resolutionLocation;
	private int texCoordLocation;
	private WebGLBuffer texCoordBuffer;
	private int positionLocation;
	private WebGLBuffer vertexPositionBuffer;
	private WebGLTexture texture;
	private CanvasElement canvasElement;





	public TexturedScene(WebGLRenderingContext ctx3d, CanvasElement canvasElement,int w, int h) {
		super(ctx3d);
		this.canvasElement = canvasElement;
		this.w = w;
		this.h = h;

		
		

		WebGLShader vs  = Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.texturingVertexShader2D().getText(), ctx3d);
		WebGLShader fs = Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.texturingFragmentShader2D().getText(), ctx3d);
		this.program = Utils.createAndUseProgram(Arrays.asList(vs,fs), ctx3d);



		resolutionLocation = ctx3d.getUniformLocation(program, "u_resolution");
		texCoordLocation = ctx3d.getAttribLocation(program, "a_texCoord");
		positionLocation = ctx3d.getAttribLocation(program, "a_position");



		//buffers


		// provide texture coordinates for the rectangle.
		texCoordBuffer = ctx3d.createBuffer();
		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, texCoordBuffer);



		ArrayBufferView  coordsBuf = Utils.Float32ArrayfromFloatArray(
				0.0f, 0.0f,
				1.0f, 0.0f,
				0.0f, 1.0f,
				0.0f, 1.0f,
				1.0f, 0.0f,
				1.0f, 1.0f);

		ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, coordsBuf, WebGLRenderingContext.STATIC_DRAW);
		ctx3d.enableVertexAttribArray(texCoordLocation);
		ctx3d.vertexAttribPointer(texCoordLocation, 2, WebGLRenderingContext.FLOAT, false, 0, 0);



		vertexPositionBuffer = ctx3d.createBuffer();
		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);




		//		ArrayBufferView ab = Utilities.createArrayBufferOfFloat32(
		//				10,20,
		//				80,20, 
		//				10,30,
		//				10,30,
		//				80,20,
		//				80,30);
		//
		//
		//
		//		ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, ab, WebGLRenderingContext.STATIC_DRAW);

		ArrayBufferView rect = createRectangleVertices( 0, 0,w,h);
		ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, rect , WebGLRenderingContext.STATIC_DRAW);

		ctx3d.enableVertexAttribArray(positionLocation);
		ctx3d.vertexAttribPointer(positionLocation, 2, WebGLRenderingContext.FLOAT, false, 0, 0);



		texture = ctx3d.createTexture();
		ctx3d.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
		// Set the parameters so we can render any size image.
		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_WRAP_S, WebGLRenderingContext.CLAMP_TO_EDGE);
		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_WRAP_T, WebGLRenderingContext.CLAMP_TO_EDGE);
		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.NEAREST);
		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.NEAREST);


		//prepare ctx for shapes
		
		setMatrix( Matrices.perspectiveMatrix(40,(float)w / (float)h, 0.1f, 1000.0f) );
		ctx3d.enable(WebGLRenderingContext.DEPTH_TEST); //Enable Depth Testing      
		ctx3d.depthFunc(WebGLRenderingContext.LEQUAL); //Set Perspective View       
		ctx3d.viewport(0, 0, w, h);



	}


	@Override
	public void draw() {

		//
		//		if(had_resize) {
		//			had_resize=false;
		//			ctx3d.viewport(0, 0, w, h);
		//			ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);
		//			ArrayBufferView rect = createRectangleVertices( 0, 0,w,h);
		//			ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, rect , WebGLRenderingContext.STATIC_DRAW);
		//		}

		WebGLRenderingContext ctx3d = this.getContext();
		Utils.clear(ctx3d);

		ctx3d.clear(WebGLRenderingContext.COLOR_BUFFER_BIT|WebGLRenderingContext.DEPTH_BUFFER_BIT);      // Clear the color as well as the depth buffer.

		ctx3d.useProgram(program);


		//		if(had_resize) {
		//			had_resize=false;
		//			
		//			perspectiveMatrix = ViewMatrix.perspectiveMatrix(40,(double)w / (double)h, 0.1, 1000.0);
		//
		//			Browser.getWindow().getConsole().log("WxH:" + w + "x"+h);
		//			ctx3d.viewport(0, 0, w, h);
		//			ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);
		//			ArrayBufferView rect = createRectangleVertices( 0, 0,w,h);
		//			ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, rect , WebGLRenderingContext.STATIC_DRAW);
		//			ctx3d.enableVertexAttribArray(positionLocation);
		//			ctx3d.vertexAttribPointer(positionLocation, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		//
		//			ctx3d.clear(WebGLRenderingContext.COLOR_BUFFER_BIT|WebGLRenderingContext.DEPTH_BUFFER_BIT);      // Clear the color as well as the depth buffer.
		//		}



		ctx3d.uniform2f(resolutionLocation,w, h);



		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, texCoordBuffer);
		ctx3d.enableVertexAttribArray(texCoordLocation);
		ctx3d.vertexAttribPointer(texCoordLocation, 2, WebGLRenderingContext.FLOAT, false, 0, 0);



		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);
		ctx3d.enableVertexAttribArray(positionLocation);
		ctx3d.vertexAttribPointer(positionLocation, 2, WebGLRenderingContext.FLOAT, false, 0, 0);


		ctx3d.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
		ctx3d.pixelStorei(WebGLRenderingContext.UNPACK_FLIP_Y_WEBGL, 0);  
		ctx3d.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, canvasElement);



		ctx3d.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 6);

		//now draw all the shapes

		this.drawShapes();
		//finished 
		ctx3d.flush();


	}


	private static ArrayBufferView createRectangleVertices(int x, int y, int w, int h) {
		int x1 = x;
		int x2 = x + w;
		int y1 = y;
		int y2 = y + h;

		return Utils.Float32ArrayfromFloatArray(x1,y1,x2,y1,x1,y2,x1,y2,x2,y1,x2,y2);		
	}



}