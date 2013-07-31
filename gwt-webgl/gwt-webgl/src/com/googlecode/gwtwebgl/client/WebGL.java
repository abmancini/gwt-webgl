package com.googlecode.gwtwebgl.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.googlecode.gwtwebgl.html.WebGLContextAttributes;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.js.html.JsWebGLContextAttributes;
import com.googlecode.gwtwebgl.js.html.JsWebGLRenderingContext;

public class WebGL {
	private WebGL() {}
	
	public static WebGLContextAttributes createAttributes() {
		return JsWebGLContextAttributes.newInstance();
	}
	
	public static WebGLRenderingContext getContext(Canvas canvas, WebGLContextAttributes attrs) {
		return _getContext(canvas.getCanvasElement(), attrs);
	}

	public static WebGLRenderingContext getContext(Canvas canvas) {
		return _getContext(canvas.getCanvasElement());
	}

	
	
	private static native JsWebGLRenderingContext _getContext(CanvasElement canvas, WebGLContextAttributes attrs) /*-{
		return canvas.getContext("experimental-webgl", attrs) || canvas.getContext("webgl", attrs);
	}-*/;
	
	private static native JsWebGLRenderingContext _getContext(CanvasElement canvas) /*-{
		return canvas.getContext("experimental-webgl") || canvas.getContext("webgl");
	}-*/;

}
