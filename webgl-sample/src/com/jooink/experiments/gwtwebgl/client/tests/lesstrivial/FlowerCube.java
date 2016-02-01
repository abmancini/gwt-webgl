package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;


import java.util.Arrays;

import com.google.gwt.typedarrays.shared.Float32Array;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.html.WebGLUniformLocation;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class FlowerCube extends Shape {
	
	private static final WebGLCube cube = new WebGLCube();
	
 	private int vertexPositionAttribute;
	private int textureCoordAttribute;
	private WebGLProgram program;
	private WebGLUniformLocation pMatrixUniform;
	private WebGLUniformLocation mvMatrixUniform;

 	private WebGLUniformLocation timeUniform;

 
	private WebGLBuffer cubeVertexPositionBuffer;
	private WebGLBuffer cubeVertexTextureCoordBuffer;
	private WebGLBuffer cubeVertexIndexBuffer;



	public FlowerCube(WebGLRenderingContext ctx) {
		this(ctx,null);
	}

	public FlowerCube(WebGLRenderingContext ctx, float[] mat) {
		super(ctx,mat);
		prepareShaders(ctx);
		prepareBuffers(ctx);
	}


	@Override
	public void draw(WebGLRenderingContext ctx3d, Float32Array modelViewMatrix, Float32Array perspectiveMatrix, float timeFromCreationInseconds) {

		ctx3d.useProgram(program);


		ctx3d.uniform1f(timeUniform, timeFromCreationInseconds/1.0f);


		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexPositionBuffer);
		ctx3d.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);

		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexTextureCoordBuffer);
		ctx3d.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);

		ctx3d.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, cubeVertexIndexBuffer);

		ctx3d.uniformMatrix4fv(pMatrixUniform, false, perspectiveMatrix );
		ctx3d.uniformMatrix4fv(mvMatrixUniform, false,  modelViewMatrix );


		ctx3d.drawElements(WebGLRenderingContext.TRIANGLES, cube.getNumIndices(), WebGLRenderingContext.UNSIGNED_SHORT, 0);

	}


	private void prepareShaders(WebGLRenderingContext ctx3d) {
		//create shaders

		//Window.alert("vertexSh: "+Shaders.INSTANCE.vertexShader3D().getText());
		WebGLShader vs  = Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader3D().getText(), ctx3d);

		//Window.alert("fragmentSh: "+Shaders.INSTANCE.fragmentShader3D().getText());
		//WebGLShader fs = Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.fragmentShader3D().getText(), ctx3d);
		WebGLShader fs = Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.flowerFragmentShader().getText(), ctx3d);

		//create program
		this.program = Utils.createAndUseProgram(Arrays.asList(vs,fs), ctx3d);


		//Link Vertex Position Attribute from Shader  
		this.vertexPositionAttribute = ctx3d.getAttribLocation(program, "aVertexPosition");  
		ctx3d.enableVertexAttribArray(vertexPositionAttribute);  

		//Link Texture Coordinate Attribute from Shader  
		this.textureCoordAttribute = ctx3d.getAttribLocation(program, "aTextureCoord");  
		ctx3d.enableVertexAttribArray(textureCoordAttribute);

		this.pMatrixUniform = ctx3d.getUniformLocation(program, "uPMatrix");
		this.mvMatrixUniform = ctx3d.getUniformLocation(program, "uMVMatrix");
	//	this.samplerUniform = ctx3d.getUniformLocation(program, "uSampler");


		this.timeUniform = ctx3d.getUniformLocation(program, "time");
	}


	private void prepareBuffers(WebGLRenderingContext ctx3d) {

		//Create a New Buffer
		cubeVertexPositionBuffer = ctx3d.createBuffer();
		//Bind it as The Current Buffer
		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexPositionBuffer);
		// Fill it With the Data

		//Window.alert("vert RETURNTED Buf len:" + ab.getByteLength());
		ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, cube.getVerticesArray(), WebGLRenderingContext.STATIC_DRAW);

		//Connect Buffer To Shader's attribute





		cubeVertexTextureCoordBuffer = ctx3d.createBuffer();
		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexTextureCoordBuffer);
		ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, cube.getTextureCoordinatesArray(), WebGLRenderingContext.STATIC_DRAW);



		cubeVertexIndexBuffer = ctx3d.createBuffer();
		ctx3d.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, cubeVertexIndexBuffer);
		ctx3d.bufferData(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, cube.getIndexesArray(), WebGLRenderingContext.STATIC_DRAW);


	}



}
