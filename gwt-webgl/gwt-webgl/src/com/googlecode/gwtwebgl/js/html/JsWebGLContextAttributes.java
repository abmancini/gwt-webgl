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
package com.googlecode.gwtwebgl.js.html;
import com.googlecode.gwtwebgl.html.WebGLContextAttributes;
import com.googlecode.gwtwebgl.utils.JsMixinBase;

public class JsWebGLContextAttributes extends JsMixinBase  implements WebGLContextAttributes {
  protected JsWebGLContextAttributes() {}

  public static native JsWebGLContextAttributes newInstance() /*-{
	  return {};
  }-*/;
  
  public final native boolean isAlpha() /*-{
  	console.log(this.alpha);
  	console.log(this.alpha || false);
  	
    return this.alpha || false;
  }-*/;

  public final native void setAlpha(boolean param_alpha) /*-{
    this.alpha = param_alpha;
  }-*/;

  public final native boolean isAntialias() /*-{
    return this.antialias || false;
  }-*/;

  public final native void setAntialias(boolean param_antialias) /*-{
    this.antialias = param_antialias;
  }-*/;

  public final native boolean isDepth() /*-{
    return this.depth || false;
  }-*/;

  public final native void setDepth(boolean param_depth) /*-{
    this.depth = param_depth;
  }-*/;

  public final native boolean isPremultipliedAlpha() /*-{
    return this.premultipliedAlpha || false;
  }-*/;

  public final native void setPremultipliedAlpha(boolean param_premultipliedAlpha) /*-{
    this.premultipliedAlpha = param_premultipliedAlpha;
  }-*/;

  public final native boolean isPreserveDrawingBuffer() /*-{
    return this.preserveDrawingBuffer || false;
  }-*/;

  public final native void setPreserveDrawingBuffer(boolean param_preserveDrawingBuffer) /*-{
    this.preserveDrawingBuffer = param_preserveDrawingBuffer;
  }-*/;

  public final native boolean isStencil() /*-{
    return this.stencil || false ;
  }-*/; 

  public final native void setStencil(boolean param_stencil) /*-{
    this.stencil = param_stencil;
  }-*/;
}
