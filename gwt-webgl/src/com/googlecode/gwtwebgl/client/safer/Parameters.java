package com.googlecode.gwtwebgl.client.safer;

import com.googlecode.gwtwebgl.html.WebGLRenderingContext;

public class Parameters {

	 public enum GetParamReturningFloat32Array {
		 ALIASED_LINE_WIDTH_RANGE(WebGLRenderingContext.ALIASED_LINE_WIDTH_RANGE),
		 ALIASED_POINT_SIZE_RANGE(WebGLRenderingContext.ALIASED_POINT_SIZE_RANGE);
		 int v;
		 GetParamReturningFloat32Array(int v) {
			 this.v = v;
		 }
	 };
	 
	 
	 public enum GetParamReturningString {
		 VERSION(WebGLRenderingContext.VERSION);
		 
		 int v;
		 GetParamReturningString(int v) {
			 this.v = v;
		 }
	 };

	 public enum GetParamReturningGLint {
		 ALPHA_BITS(WebGLRenderingContext.ALPHA_BITS);
		 int v;
		 GetParamReturningGLint(int v) {
			 this.v = v;
		 }
		 public int getValue() {
			 return v;
		 }
	 };


}
