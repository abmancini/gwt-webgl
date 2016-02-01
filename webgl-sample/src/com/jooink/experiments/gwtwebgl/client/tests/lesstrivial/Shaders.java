package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Shaders extends ClientBundle {

	public static Shaders INSTANCE = GWT.create(Shaders.class);
	
	@Source("vertexShader3D.txt")
	public TextResource vertexShader3D();

	@Source("fragmentShader3D.txt")
	public TextResource fragmentShader3D();
	
	@Source("flowerFragmentShader.txt")
	public TextResource flowerFragmentShader();
	
	@Source("heartFragmentShader.txt")
	public TextResource heartFragmentShader();
	
	
	@Source("texturingVertexShader2D.txt")
	public TextResource texturingVertexShader2D();

	@Source("texturingFragmentShader2D.txt")
	public TextResource texturingFragmentShader2D();
	
	@Source("processingFragmentShader2D.txt")
	public TextResource processingFragmentShader2D();

	@Source("blendingFragmentShader2D.txt")
	public TextResource blendingFragmentShader2D();

	  
	
	@Source("phongVertexShader3D.txt")
	public TextResource phongVertexShader3D();

	@Source("phongFragmentShader3D.txt")
	public TextResource phongFragmentShader3D();

	
	@Source("texturingPhongVertexShader3D.txt")
	public TextResource texturingPhongVertexShader3D();

	@Source("texturingPhongFragmentShader3D.txt")
	public TextResource texturingPhongFragmentShader3D();

	

	@Source("vertexShader2D.txt")
	public TextResource vertexShader2D();

	@Source("fragmentShader2D.txt")
	public TextResource fragmentShader2D();


	@Source("simpleVertexShader.txt")
	public TextResource simpleVertexShader();

	@Source("simpleFragmentShader.txt")
	public TextResource simpleFragmentShader();

	
	
	
}
