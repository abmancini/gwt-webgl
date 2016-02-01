/*
 * Copyright 2012 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtwebgl.html;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


/**
 * 
 */

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="Object")
public class WebGLContextAttributes {


	@JsProperty
	public native boolean isAlpha();

	@JsProperty
	public native void setAlpha(boolean arg);
	
	@JsProperty
	public native boolean isAntialias();
	
	@JsProperty
	public native void setAntialias(boolean arg);
	
	@JsProperty
	public native boolean isDepth();
	
	@JsProperty
	public native void setDepth(boolean arg);
	
	@JsProperty	
	public native boolean isPremultipliedAlpha();
	
	@JsProperty
	public native void setPremultipliedAlpha(boolean arg);
	
	@JsProperty
	public native boolean isPreserveDrawingBuffer();
	
	@JsProperty
	public native void setPreserveDrawingBuffer(boolean arg);
	
	@JsProperty
	public native boolean isStencil();
	
	@JsProperty
	public native void setStencil(boolean arg);
}