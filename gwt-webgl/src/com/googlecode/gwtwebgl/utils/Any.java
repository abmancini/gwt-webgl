package com.googlecode.gwtwebgl.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Int32Array;
import com.google.gwt.typedarrays.shared.Uint32Array;
import com.googlecode.gwtwebgl.html.WebGLFramebuffer;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderbuffer;
import com.googlecode.gwtwebgl.html.WebGLTexture;
import com.googlecode.gwtwebgl.html.WebGLBuffer;

public class Any extends JavaScriptObject /*implements Any */{
	protected Any() {}
	
	////@Override
	public final native int getInt() /*-{
		return this;
	}-*/;
	
	////@Override
	public final native boolean getBoolean() /*-{
		return this;
	}-*/;
	
	////@Override
	public final native float getFloat() /*-{
		return this;
	}-*/;

	//@Override
	public final native double getDouble() /*-{
		return this;
	}-*/;
	
	//@Override
	public final native Uint32Array getUint32Array() /*-{
		return this;
	}-*/;

	//@Override
	public final native Int32Array getInt32Array() /*-{
		return this;
	}-*/;

	//@Override
	public final native Float32Array getFloat32Array() /*-{
		return this;
	}-*/;

	//@Override
	public final native WebGLBuffer getWebGLBuffer() /*-{
		return this;
	}-*/;

	
	//@Override
	public final native WebGLProgram getWebGLProgram() /*-{
		return this;
	}-*/;


	//@Override
	public final native WebGLTexture getWebGLTexture() /*-{
		return this;
	}-*/;


	//@Override
	public final native WebGLRenderbuffer getWebGLRenderbuffer() /*-{
		return this;
	}-*/;


	//@Override
	public final native WebGLFramebuffer getWebGLFramebuffer() /*-{
		return this;
	}-*/;

	//@Override
	public final native JsArrayBoolean getJsArrayBoolean() /*-{
		return this;
	}-*/;


	//@Override
	public final native Object get() /*-{
		return this;
	}-*/;

	//@Override
	public final native boolean isNull() /*-{
		return this==null;
	}-*/;


	//@Override
	public final native String getString() /*-{
		return this;
	}-*/;

	//@Override
	public final native String castToString() /*-{
		return ''+this;
	}-*/;


}
