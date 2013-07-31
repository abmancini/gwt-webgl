package com.jooink.experiments.gwtwebgl.client.tests.cube;

import java.util.Arrays;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.html.WebGLUniformLocation;
import com.jooink.experiments.gwtwebgl.client.Test;
import com.jooink.experiments.gwtwebgl.client.Utils;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SimpleCube extends Test {

	
	@Override
	public String getName() {
		return "SimpleCube";
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


		ctx.enable(WebGLRenderingContext.DEPTH_TEST);
		ctx.depthFunc(WebGLRenderingContext.LEQUAL); 





		WebGLShader vs  =
			Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader().getText(), ctx);

		WebGLShader fs =
			Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER,Shaders.INSTANCE.fragmentShader().getText(), ctx);

		WebGLProgram program =
			Utils.createAndUseProgram(Arrays.asList(vs,fs), ctx);




		WebGLUniformLocation pMatrixUniform = ctx.getUniformLocation(program, "uPMatrix");

		final WebGLUniformLocation mvMatrixUniform = ctx.getUniformLocation(program, "uMVMatrix");

		final WebGLUniformLocation  nmMatrixUniform = ctx.getUniformLocation(program, "uNormalMatrix");        

		WebGLUniformLocation colorUniform = ctx.getUniformLocation(program, "uColor");

		WebGLUniformLocation ambientColorUniform = ctx.getUniformLocation(program, "uAmbientLight");

		WebGLUniformLocation lightColorUniform =
			ctx.getUniformLocation(program, "uLightColor");

		WebGLUniformLocation lightDirectionUniform =
			ctx.getUniformLocation(program, "uLightDirection");


		int vertexPositionAttribute =
			ctx.getAttribLocation(program, "aVertexPosition");

		int vertexNormalAttribute =
			ctx.getAttribLocation(program, "aVertexNormal"); 



		WebGLCube cube = new WebGLCube();

		WebGLBuffer verticesPositionsBuffer = ctx.createBuffer();

		ctx.bindBuffer( WebGLRenderingContext.ARRAY_BUFFER, verticesPositionsBuffer);
		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, cube.getVerticesArray(), WebGLRenderingContext.STATIC_DRAW);

		ctx.vertexAttribPointer(vertexPositionAttribute, 3,                 
		WebGLRenderingContext.FLOAT, false, 0, 0);

		ctx.enableVertexAttribArray(vertexPositionAttribute);

		//note: buffer operations are referred to the
		//currently binded buffer

		WebGLBuffer verticesNormalsBuffer = ctx.createBuffer();



		ctx.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER,verticesNormalsBuffer);

		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, cube.getNormalsArray(), WebGLRenderingContext.STATIC_DRAW);

		ctx.vertexAttribPointer(vertexNormalAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);        

		ctx.enableVertexAttribArray(vertexNormalAttribute);


		WebGLBuffer indexesBuffer = ctx.createBuffer();   

		ctx.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, indexesBuffer);

		ctx.bufferData(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER,  cube.getIndexesArray(), WebGLRenderingContext.STATIC_DRAW);

		//this is not an attribute ARRAY_BUFFER so we do not need
		//attributes stuff


		final int numIndicies = cube.getNumIndices();

		
		float[] perspectiveMatrix = Matrices.perspectiveMatrix(40,640.0f/480.0f, 0.1f, 1000.0f);

		float[] modelViewMatrix = Matrices.lookaAtMatrix(new float[] {3.5f,3.5f,4.0f} , new float[]{0,0,1},new float[]{0,0,1});


		ctx.uniform4f(colorUniform, .0f,.6f,0f,1f);
		ctx.uniform3f(ambientColorUniform, .2f, .2f, .2f);
		ctx.uniform3f(lightColorUniform, 0.8f, 0.8f, 0.8f);

		ctx.uniform3f(lightDirectionUniform, 0.0f, 1.0f/(float)Math.sqrt(2.0), 1.0f/(float)Math.sqrt(2.0));



		ctx.uniformMatrix4fv(pMatrixUniform, false, Utils.Float32ArrayfromFloatArray(perspectiveMatrix));



		draw(mvMatrixUniform,nmMatrixUniform,numIndicies,modelViewMatrix,ctx);
		
		Timer timer = new Timer() {
			private double t = Math.PI/4.0;
			private final double alpha = Math.cos(t);
			private final double dt = -0.01;
			@Override
			public void run() {
				t+= dt;
				float ex = (float)(3.5*Math.cos(t)/alpha);
				float ey = (float)(3.5*Math.sin(t)/alpha);
				float ez = 4.0f;
				//Browser.getWindow().getConsole().log("["+ ex +","+ey+"]");
				float[] M = Matrices.lookaAtMatrix(new float[] {ex,ey,ez} , new float[]{0,0,1},new float[]{0,0,1});

				draw(mvMatrixUniform,nmMatrixUniform, numIndicies, M, ctx);
			}
		};
		
				
		
		timer.scheduleRepeating(10);
		
		
		
	}
	
	
	private void draw(WebGLUniformLocation mvMatrixUniform,WebGLUniformLocation nmMatrixUniform, int numIndicies, float[] modelViewMatrix, WebGLRenderingContext ctx) {
		float[] normalTransformMatrix=Matrices.transpose(Matrices.inverseMatrix(modelViewMatrix));
		ctx.uniformMatrix4fv(nmMatrixUniform, false, Utils.Float32ArrayfromFloatArray(normalTransformMatrix));
		ctx.uniformMatrix4fv(mvMatrixUniform, false, Utils.Float32ArrayfromFloatArray(modelViewMatrix));

		ctx.clear( WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);     
		ctx.drawElements(WebGLRenderingContext.TRIANGLES,numIndicies, WebGLRenderingContext.UNSIGNED_SHORT, 0);

	}


	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
