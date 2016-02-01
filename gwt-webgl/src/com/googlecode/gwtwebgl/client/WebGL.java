package com.googlecode.gwtwebgl.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.googlecode.gwtwebgl.html.WebGLContextAttributes;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;

public class WebGL {
	private WebGL() {}
	
	//unneded, keep the jsni based interface intact
	public static WebGLContextAttributes createAttributes() {
		return new WebGLContextAttributes();
	}
	
	public static WebGLRenderingContext getContext(Canvas canvas, WebGLContextAttributes attrs) {
		return _getContext(canvas.getCanvasElement(), attrs);
	}

	public static WebGLRenderingContext getContext(Canvas canvas) {
		return _getContext(canvas.getCanvasElement());
	}
	
	private static native WebGLRenderingContext _getContext(CanvasElement canvas, WebGLContextAttributes attrs) /*-{
		
		canvas.addEventListener("webglcontextlost", function(event) {
    		event.preventDefault();
    		alert('Context LOST');
		}, false);
		
		return canvas.getContext("experimental-webgl", attrs) || canvas.getContext("webgl", attrs);
	}-*/;
	
	private static native WebGLRenderingContext _getContext(CanvasElement canvas) /*-{
		canvas.addEventListener("webglcontextlost", function(event) {
    		event.preventDefault();
    		alert('Context LOST');
		}, false);
		
		return canvas.getContext("experimental-webgl") || canvas.getContext("webgl");
	}-*/;

	public static boolean isSupported() {
		return true;
	}

}
