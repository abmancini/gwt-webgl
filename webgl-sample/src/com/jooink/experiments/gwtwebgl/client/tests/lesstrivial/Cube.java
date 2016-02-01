package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;


import java.util.Arrays;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.html.WebGLTexture;
import com.googlecode.gwtwebgl.html.WebGLUniformLocation;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class Cube extends Shape  {


	private boolean textureLoaded = false;

	private WebGLTexture gl_texture;

	private static final WebGLCube cube = new WebGLCube();
	

	private int vertexPositionAttribute;
	private int textureCoordAttribute;
	private WebGLProgram program;
	private WebGLUniformLocation pMatrixUniform;
	private WebGLUniformLocation mvMatrixUniform;
	private WebGLUniformLocation samplerUniform;

	private WebGLBuffer cubeVertexPositionBuffer;
	private WebGLBuffer cubeVertexTextureCoordBuffer;
	private WebGLBuffer cubeVertexIndexBuffer;


	public interface  Resource extends ClientBundle {
		@Source("marker.gif")
		ImageResource tile();
	}
	
	private static Resource resource;
	
	private static Resource getDefaultResource() {
		if(resource == null)
			resource = GWT.create(Resource.class);
		return resource;
	}

	public Cube(WebGLRenderingContext ctx) {
		this(ctx, getDefaultResource().tile(), null);
	}
	
	public Cube(WebGLRenderingContext ctx, float[] mat) {
		this(ctx, getDefaultResource().tile(), mat);
	}
	
	public Cube(WebGLRenderingContext ctx, ImageResource tile) {
		this(ctx, tile, null);
	}
	
	public Cube(WebGLRenderingContext ctx,  ImageResource tile, float[] mat) {
		super(ctx,mat);
		
		prepareShaders(ctx);
		prepareBuffers(ctx);
		prepareTexture(ctx,tile);

	}



	@Override
	public void draw(WebGLRenderingContext ctx3d, Float32Array modelViewMatrix, Float32Array perspectiveMatrix, float unusedTime) {

		if(!textureLoaded)
			return;
		
		ctx3d.useProgram(program);
		
		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexPositionBuffer);
		ctx3d.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);

		ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, cubeVertexTextureCoordBuffer);
		ctx3d.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);


		//Set slot 0 as the active Texture
		ctx3d.activeTexture(WebGLRenderingContext.TEXTURE0);

		ctx3d.bindTexture(WebGLRenderingContext.TEXTURE_2D, this.gl_texture);
		//Update The Texture Sampler in the fragment shader to use slot 0
		ctx3d.uniform1i(samplerUniform, 0);





		ctx3d.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, cubeVertexIndexBuffer);

		ctx3d.uniformMatrix4fv(pMatrixUniform, false, perspectiveMatrix);
		ctx3d.uniformMatrix4fv(mvMatrixUniform, false,  modelViewMatrix);


		ctx3d.drawElements(WebGLRenderingContext.TRIANGLES, cube.getNumIndices(), WebGLRenderingContext.UNSIGNED_SHORT, 0);


	}


	private void prepareShaders(WebGLRenderingContext ctx3d) {
		//create shaders

		//Window.alert("vertexSh: "+Shaders.INSTANCE.vertexShader3D().getText());
		WebGLShader vs  = Utils.createShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader3D().getText(), ctx3d);

		//Window.alert("fragmentSh: "+Shaders.INSTANCE.fragmentShader3D().getText());
		//WebGLShader fs = Utilities.createShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.fragmentShader3D().getText(), ctx3d);
		WebGLShader fs = Utils.createShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.fragmentShader3D().getText(), ctx3d);

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
		this.samplerUniform = ctx3d.getUniformLocation(program, "uSampler");

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



	private void prepareTexture(final WebGLRenderingContext ctx3d, ImageResource tile) {

		//Create a new Texture and Assign it as the active one  
		gl_texture = ctx3d.createTexture();  

		final Image img = new Image();
		img.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		RootPanel.get().add(img);
		img.addLoadHandler(new LoadHandler() {

			@Override
			public void onLoad(LoadEvent event) {
				//image loaded
				RootPanel.get().remove(img);
				onTextureLoaded(img,ctx3d);
			}
		});

		img.setResource(tile);

	}

	private void onTextureLoaded(Image img, WebGLRenderingContext ctx3d) {

		//bind the texture  
		ctx3d.bindTexture(WebGLRenderingContext.TEXTURE_2D, gl_texture);

		//Flip Positive Y (Optional)  
		ctx3d.pixelStorei(WebGLRenderingContext.UNPACK_FLIP_Y_WEBGL, 1);  

		//Load in The Image  
		ctx3d.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, ImageElement.as(img.getElement()));    

		//Setup Scaling properties  
		//		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.LINEAR);    
		//		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.LINEAR_MIPMAP_NEAREST);    
		//		ctx3d.generateMipmap(WebGLRenderingContext.TEXTURE_2D);   


		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.NEAREST);    
		ctx3d.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.NEAREST);    

		//Unbind the texture  
		ctx3d.bindTexture(WebGLRenderingContext.TEXTURE_2D, null);  

		textureLoaded = true;
	}






}
