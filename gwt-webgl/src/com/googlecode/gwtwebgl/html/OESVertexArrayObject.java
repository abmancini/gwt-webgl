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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;



@JsType(namespace = JsPackage.GLOBAL, isNative = true)
public interface OESVertexArrayObject {

	@JsOverlay
	static final int VERTEX_ARRAY_BINDING_OES = 0x85B5;

	@JsMethod
	void bindVertexArrayOES(WebGLVertexArrayObjectOES arrayObject);

	@JsMethod
	WebGLVertexArrayObjectOES createVertexArrayOES();

	@JsMethod
	void deleteVertexArrayOES(WebGLVertexArrayObjectOES arrayObject);

	@JsMethod
	boolean isVertexArrayOES(WebGLVertexArrayObjectOES arrayObject);
}
