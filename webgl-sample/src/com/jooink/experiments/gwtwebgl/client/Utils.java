package com.jooink.experiments.gwtwebgl.client;

import java.util.List;

import com.google.gwt.typedarrays.client.Float32ArrayNative;
import com.google.gwt.typedarrays.client.Uint16ArrayNative;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Uint16Array;
import com.google.gwt.user.client.Window;
import com.googlecode.gwtwebgl.html.WebGLProgram;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.html.WebGLShader;
import com.googlecode.gwtwebgl.utils.Any;
import com.jooink.experiments.gwtwebgl.client.Webgl_sample.Console;

public class Utils {

	public static  WebGLShader createShader(int type,String code,WebGLRenderingContext ctx) {
		WebGLShader shader = ctx.createShader(type);
		ctx.shaderSource(shader,code );
		ctx.compileShader(shader);
		if(testShaderStatus(ctx,shader))	
			return shader;
		//else error
		String lastError = ctx.getShaderInfoLog(shader);
		Window.alert("*** Error compiling shader '" + shader + "':" + lastError);
		ctx.deleteShader(shader);
		return null;
	}

	private static boolean testShaderStatus(WebGLRenderingContext ctx, WebGLShader shader) {
		Any a = ctx.getShaderParameter(shader, WebGLRenderingContext.COMPILE_STATUS);
		return a.getBoolean();
	}

	public static WebGLProgram createAndUseProgram(List<WebGLShader> shaders, WebGLRenderingContext ctx) {
		WebGLProgram program = ctx.createProgram();

		for(WebGLShader s : shaders)
			ctx.attachShader(program, s);

		ctx.linkProgram(program);
		if(ctx.getProgramParameter(program, WebGLRenderingContext.LINK_STATUS).getBoolean()) {	
			ctx.useProgram(program);
			return program;
		}
		//else error
		String lastError = ctx.getProgramInfoLog(program);
		Window.alert("*** Error compiling program '" + program + "':" + lastError);
		ctx.deleteProgram(program);
		return null;

	}


	//	private static native boolean testShaderStatus(WebGLRenderingContext gl, WebGLShader shader) /*-{
	//
	//		// Check the compile status
	//		  var compiled = gl.getShaderParameter(shader, gl.COMPILE_STATUS);
	//		  if (!compiled) {
	//		    // Something went wrong during compilation; get the error
	//		    lastError = gl.getShaderInfoLog(shader);
	//		    alert("*** Error compiling shader '" + shader + "':" + lastError);
	//		    gl.deleteShader(shader);
	//		    return false;
	//		  }
	//		//alert("shader ok");
	//
	//		  return true;
	//	}-*/;
	//
	//
	//	
	//	
	//	private static native boolean testProgramStatus(WebGLRenderingContext gl, WebGLProgram program) /*-{
	//	  // Check the link status
	//	  var linked = gl.getProgramParameter(program, gl.LINK_STATUS);
	//	  if (!linked) {
	//	      // something went wrong with the link
	//	      lastError = gl.getProgramInfoLog (program);
	//	      alert("Error in program linking:" + lastError);
	//
	//	      gl.deleteProgram(program);
	//	      return false;
	//	  }
	//	 //alert("program ok");
	//	  return true;
	//	}-*/;



	public static Float32Array Float32ArrayfromFloatArray(float... floatArray) {
		Float32Array a = Float32ArrayNative.create(floatArray.length);
		a.set(floatArray);
		return a;
	}


	public static Uint16Array Uint32ArrayFromIntArray(int... intArray) {
		Uint16Array a = Uint16ArrayNative.create(intArray.length);
		a.set(intArray);
		return a;
	}



//	public static Float32Array Float32ArrayfromFloatArray(double... doubleArray) {
//		return Float32ArrayfromDoubleArray(doubleArray);
//	}

	public static final Float32Array Float32ArrayfromDoubleArray(double... doubleArray) {
		//copy into float array
		float[] floatArray = new float[doubleArray.length];
		for (int i = 0 ; i < doubleArray.length; i++)
		{
			floatArray[i] = (float) doubleArray[i];
		}
		System.err.println("Float32ArrayfromDoubleArray is overkill DO NOT USE");

		return Float32ArrayfromFloatArray(floatArray);

	}

	public static void clear(WebGLRenderingContext ctx3d) {
		ctx3d.clearColor(0.2f, 0.2f, 0.2f, 1.0f);                    // Set clear color to black, fully opaque
		ctx3d.clear(WebGLRenderingContext.COLOR_BUFFER_BIT|WebGLRenderingContext.DEPTH_BUFFER_BIT);      // Clear the color as well as the depth buffer.

	}






}
