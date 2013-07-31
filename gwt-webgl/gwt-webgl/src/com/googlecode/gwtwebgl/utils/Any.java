package com.googlecode.gwtwebgl.utils;

import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Int32Array;
import com.google.gwt.typedarrays.shared.Uint32Array;
import com.googlecode.gwtwebgl.html.WebGLBuffer;
import com.googlecode.gwtwebgl.html.WebGLFramebuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderbuffer;
import com.googlecode.gwtwebgl.html.WebGLTexture;

public interface Any {
	public int getInt();
	public boolean getBoolean();
	public float getFloat();
	public double getDouble();
	public Uint32Array getUint32Array();
	public Float32Array getFloat32Array();
	public Object get();
	public Int32Array getInt32Array();
	public WebGLBuffer getWebGLBuffer();
	public WebGLProgram getWebGLProgram();
	public WebGLTexture getWebGLTexture();
	public WebGLRenderbuffer getWebGLRenderbuffer();
	public WebGLFramebuffer getWebGLFramebuffer();
	public JsArrayBoolean getJsArrayBoolean();
	public String castToString();
	boolean isNull();
	
}
