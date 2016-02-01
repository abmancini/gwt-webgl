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

import com.google.gwt.canvas.dom.client.ImageData;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Int32Array;
import com.googlecode.gwtwebgl.utils.Any;

/**
 * 
 */

@JsType(namespace = JsPackage.GLOBAL, isNative = true)
public interface WebGLRenderingContext {


	@JsOverlay static final int ACTIVE_ATTRIBUTES = 0x8B89;

	@JsOverlay static final int ACTIVE_TEXTURE = 0x84E0;

	@JsOverlay static final int ACTIVE_UNIFORMS = 0x8B86;

	@JsOverlay static final int ALIASED_LINE_WIDTH_RANGE = 0x846E;

	@JsOverlay static final int ALIASED_POINT_SIZE_RANGE = 0x846D;

	@JsOverlay static final int ALPHA = 0x1906;

	@JsOverlay static final int ALPHA_BITS = 0x0D55;

	@JsOverlay static final int ALWAYS = 0x0207;

	@JsOverlay static final int ARRAY_BUFFER = 0x8892;

	@JsOverlay static final int ARRAY_BUFFER_BINDING = 0x8894;

	@JsOverlay static final int ATTACHED_SHADERS = 0x8B85;

	@JsOverlay static final int BACK = 0x0405;

	@JsOverlay static final int BLEND = 0x0BE2;

	@JsOverlay static final int BLEND_COLOR = 0x8005;

	@JsOverlay static final int BLEND_DST_ALPHA = 0x80CA;

	@JsOverlay static final int BLEND_DST_RGB = 0x80C8;

	@JsOverlay static final int BLEND_EQUATION = 0x8009;

	@JsOverlay static final int BLEND_EQUATION_ALPHA = 0x883D;

	@JsOverlay static final int BLEND_EQUATION_RGB = 0x8009;

	@JsOverlay static final int BLEND_SRC_ALPHA = 0x80CB;

	@JsOverlay static final int BLEND_SRC_RGB = 0x80C9;

	@JsOverlay static final int BLUE_BITS = 0x0D54;

	@JsOverlay static final int BOOL = 0x8B56;

	@JsOverlay static final int BOOL_VEC2 = 0x8B57;

	@JsOverlay static final int BOOL_VEC3 = 0x8B58;

	@JsOverlay static final int BOOL_VEC4 = 0x8B59;

	@JsOverlay static final int BROWSER_DEFAULT_WEBGL = 0x9244;

	@JsOverlay static final int BUFFER_SIZE = 0x8764;

	@JsOverlay static final int BUFFER_USAGE = 0x8765;

	@JsOverlay static final int BYTE = 0x1400;

	@JsOverlay static final int CCW = 0x0901;

	@JsOverlay static final int CLAMP_TO_EDGE = 0x812F;

	@JsOverlay static final int COLOR_ATTACHMENT0 = 0x8CE0;

	@JsOverlay static final int COLOR_BUFFER_BIT = 0x00004000;

	@JsOverlay static final int COLOR_CLEAR_VALUE = 0x0C22;

	@JsOverlay static final int COLOR_WRITEMASK = 0x0C23;

	@JsOverlay static final int COMPILE_STATUS = 0x8B81;

	@JsOverlay static final int COMPRESSED_TEXTURE_FORMATS = 0x86A3;

	@JsOverlay static final int CONSTANT_ALPHA = 0x8003;

	@JsOverlay static final int CONSTANT_COLOR = 0x8001;

	@JsOverlay static final int CONTEXT_LOST_WEBGL = 0x9242;

	@JsOverlay static final int CULL_FACE = 0x0B44;

	@JsOverlay static final int CULL_FACE_MODE = 0x0B45;

	@JsOverlay static final int CURRENT_PROGRAM = 0x8B8D;

	@JsOverlay static final int CURRENT_VERTEX_ATTRIB = 0x8626;

	@JsOverlay static final int CW = 0x0900;

	@JsOverlay static final int DECR = 0x1E03;

	@JsOverlay static final int DECR_WRAP = 0x8508;

	@JsOverlay static final int DELETE_STATUS = 0x8B80;

	@JsOverlay static final int DEPTH_ATTACHMENT = 0x8D00;

	@JsOverlay static final int DEPTH_BITS = 0x0D56;

	@JsOverlay static final int DEPTH_BUFFER_BIT = 0x00000100;

	@JsOverlay static final int DEPTH_CLEAR_VALUE = 0x0B73;

	@JsOverlay static final int DEPTH_COMPONENT = 0x1902;

	@JsOverlay static final int DEPTH_COMPONENT16 = 0x81A5;

	@JsOverlay static final int DEPTH_FUNC = 0x0B74;

	@JsOverlay static final int DEPTH_RANGE = 0x0B70;

	@JsOverlay static final int DEPTH_STENCIL = 0x84F9;

	@JsOverlay static final int DEPTH_STENCIL_ATTACHMENT = 0x821A;

	@JsOverlay static final int DEPTH_TEST = 0x0B71;

	@JsOverlay static final int DEPTH_WRITEMASK = 0x0B72;

	@JsOverlay static final int DITHER = 0x0BD0;

	@JsOverlay static final int DONT_CARE = 0x1100;

	@JsOverlay static final int DST_ALPHA = 0x0304;

	@JsOverlay static final int DST_COLOR = 0x0306;

	@JsOverlay static final int DYNAMIC_DRAW = 0x88E8;

	@JsOverlay static final int ELEMENT_ARRAY_BUFFER = 0x8893;

	@JsOverlay static final int ELEMENT_ARRAY_BUFFER_BINDING = 0x8895;

	@JsOverlay static final int EQUAL = 0x0202;

	@JsOverlay static final int FASTEST = 0x1101;

	@JsOverlay static final int FLOAT = 0x1406;

	@JsOverlay static final int FLOAT_MAT2 = 0x8B5A;

	@JsOverlay static final int FLOAT_MAT3 = 0x8B5B;

	@JsOverlay static final int FLOAT_MAT4 = 0x8B5C;

	@JsOverlay static final int FLOAT_VEC2 = 0x8B50;

	@JsOverlay static final int FLOAT_VEC3 = 0x8B51;

	@JsOverlay static final int FLOAT_VEC4 = 0x8B52;

	@JsOverlay static final int FRAGMENT_SHADER = 0x8B30;

	@JsOverlay static final int FRAMEBUFFER = 0x8D40;

	@JsOverlay static final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1;

	@JsOverlay static final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0;

	@JsOverlay static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;

	@JsOverlay static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2;

	@JsOverlay static final int FRAMEBUFFER_BINDING = 0x8CA6;

	@JsOverlay static final int FRAMEBUFFER_COMPLETE = 0x8CD5;

	@JsOverlay static final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6;

	@JsOverlay static final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS = 0x8CD9;

	@JsOverlay static final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;

	@JsOverlay static final int FRAMEBUFFER_UNSUPPORTED = 0x8CDD;

	@JsOverlay static final int FRONT = 0x0404;

	@JsOverlay static final int FRONT_AND_BACK = 0x0408;

	@JsOverlay static final int FRONT_FACE = 0x0B46;

	@JsOverlay static final int FUNC_ADD = 0x8006;

	@JsOverlay static final int FUNC_REVERSE_SUBTRACT = 0x800B;

	@JsOverlay static final int FUNC_SUBTRACT = 0x800A;

	@JsOverlay static final int GENERATE_MIPMAP_HINT = 0x8192;

	@JsOverlay static final int GEQUAL = 0x0206;

	@JsOverlay static final int GREATER = 0x0204;

	@JsOverlay static final int GREEN_BITS = 0x0D53;

	@JsOverlay static final int HIGH_FLOAT = 0x8DF2;

	@JsOverlay static final int HIGH_INT = 0x8DF5;

	@JsOverlay static final int INCR = 0x1E02;

	@JsOverlay static final int INCR_WRAP = 0x8507;

	@JsOverlay static final int INT = 0x1404;

	@JsOverlay static final int INT_VEC2 = 0x8B53;

	@JsOverlay static final int INT_VEC3 = 0x8B54;

	@JsOverlay static final int INT_VEC4 = 0x8B55;

	@JsOverlay static final int INVALID_ENUM = 0x0500;

	@JsOverlay static final int INVALID_FRAMEBUFFER_OPERATION = 0x0506;

	@JsOverlay static final int INVALID_OPERATION = 0x0502;

	@JsOverlay static final int INVALID_VALUE = 0x0501;

	@JsOverlay static final int INVERT = 0x150A;

	@JsOverlay static final int KEEP = 0x1E00;

	@JsOverlay static final int LEQUAL = 0x0203;

	@JsOverlay static final int LESS = 0x0201;

	@JsOverlay static final int LINEAR = 0x2601;

	@JsOverlay static final int LINEAR_MIPMAP_LINEAR = 0x2703;

	@JsOverlay static final int LINEAR_MIPMAP_NEAREST = 0x2701;

	@JsOverlay static final int LINES = 0x0001;

	@JsOverlay static final int LINE_LOOP = 0x0002;

	@JsOverlay static final int LINE_STRIP = 0x0003;

	@JsOverlay static final int LINE_WIDTH = 0x0B21;

	@JsOverlay static final int LINK_STATUS = 0x8B82;

	@JsOverlay static final int LOW_FLOAT = 0x8DF0;

	@JsOverlay static final int LOW_INT = 0x8DF3;

	@JsOverlay static final int LUMINANCE = 0x1909;

	@JsOverlay static final int LUMINANCE_ALPHA = 0x190A;

	@JsOverlay static final int MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;

	@JsOverlay static final int MAX_CUBE_MAP_TEXTURE_SIZE = 0x851C;

	@JsOverlay static final int MAX_FRAGMENT_UNIFORM_VECTORS = 0x8DFD;

	@JsOverlay static final int MAX_RENDERBUFFER_SIZE = 0x84E8;

	@JsOverlay static final int MAX_TEXTURE_IMAGE_UNITS = 0x8872;

	@JsOverlay static final int MAX_TEXTURE_SIZE = 0x0D33;

	@JsOverlay static final int MAX_VARYING_VECTORS = 0x8DFC;

	@JsOverlay static final int MAX_VERTEX_ATTRIBS = 0x8869;

	@JsOverlay static final int MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8B4C;

	@JsOverlay static final int MAX_VERTEX_UNIFORM_VECTORS = 0x8DFB;

	@JsOverlay static final int MAX_VIEWPORT_DIMS = 0x0D3A;

	@JsOverlay static final int MEDIUM_FLOAT = 0x8DF1;

	@JsOverlay static final int MEDIUM_INT = 0x8DF4;

	@JsOverlay static final int MIRRORED_REPEAT = 0x8370;

	@JsOverlay static final int NEAREST = 0x2600;

	@JsOverlay static final int NEAREST_MIPMAP_LINEAR = 0x2702;

	@JsOverlay static final int NEAREST_MIPMAP_NEAREST = 0x2700;

	@JsOverlay static final int NEVER = 0x0200;

	@JsOverlay static final int NICEST = 0x1102;

	@JsOverlay static final int NONE = 0;

	@JsOverlay static final int NOTEQUAL = 0x0205;

	@JsOverlay static final int NO_ERROR = 0;

	@JsOverlay static final int ONE = 1;

	@JsOverlay static final int ONE_MINUS_CONSTANT_ALPHA = 0x8004;

	@JsOverlay static final int ONE_MINUS_CONSTANT_COLOR = 0x8002;

	@JsOverlay static final int ONE_MINUS_DST_ALPHA = 0x0305;

	@JsOverlay static final int ONE_MINUS_DST_COLOR = 0x0307;

	@JsOverlay static final int ONE_MINUS_SRC_ALPHA = 0x0303;

	@JsOverlay static final int ONE_MINUS_SRC_COLOR = 0x0301;

	@JsOverlay static final int OUT_OF_MEMORY = 0x0505;

	@JsOverlay static final int PACK_ALIGNMENT = 0x0D05;

	@JsOverlay static final int POINTS = 0x0000;

	@JsOverlay static final int POLYGON_OFFSET_FACTOR = 0x8038;

	@JsOverlay static final int POLYGON_OFFSET_FILL = 0x8037;

	@JsOverlay static final int POLYGON_OFFSET_UNITS = 0x2A00;

	@JsOverlay static final int RED_BITS = 0x0D52;

	@JsOverlay static final int RENDERBUFFER = 0x8D41;

	@JsOverlay static final int RENDERBUFFER_ALPHA_SIZE = 0x8D53;

	@JsOverlay static final int RENDERBUFFER_BINDING = 0x8CA7;

	@JsOverlay static final int RENDERBUFFER_BLUE_SIZE = 0x8D52;

	@JsOverlay static final int RENDERBUFFER_DEPTH_SIZE = 0x8D54;

	@JsOverlay static final int RENDERBUFFER_GREEN_SIZE = 0x8D51;

	@JsOverlay static final int RENDERBUFFER_HEIGHT = 0x8D43;

	@JsOverlay static final int RENDERBUFFER_INTERNAL_FORMAT = 0x8D44;

	@JsOverlay static final int RENDERBUFFER_RED_SIZE = 0x8D50;

	@JsOverlay static final int RENDERBUFFER_STENCIL_SIZE = 0x8D55;

	@JsOverlay static final int RENDERBUFFER_WIDTH = 0x8D42;

	@JsOverlay static final int RENDERER = 0x1F01;

	@JsOverlay static final int REPEAT = 0x2901;

	@JsOverlay static final int REPLACE = 0x1E01;

	@JsOverlay static final int RGB = 0x1907;

	@JsOverlay static final int RGB565 = 0x8D62;

	@JsOverlay static final int RGB5_A1 = 0x8057;

	@JsOverlay static final int RGBA = 0x1908;

	@JsOverlay static final int RGBA4 = 0x8056;

	@JsOverlay static final int SAMPLER_2D = 0x8B5E;

	@JsOverlay static final int SAMPLER_CUBE = 0x8B60;

	@JsOverlay static final int SAMPLES = 0x80A9;

	@JsOverlay static final int SAMPLE_ALPHA_TO_COVERAGE = 0x809E;

	@JsOverlay static final int SAMPLE_BUFFERS = 0x80A8;

	@JsOverlay static final int SAMPLE_COVERAGE = 0x80A0;

	@JsOverlay static final int SAMPLE_COVERAGE_INVERT = 0x80AB;

	@JsOverlay static final int SAMPLE_COVERAGE_VALUE = 0x80AA;

	@JsOverlay static final int SCISSOR_BOX = 0x0C10;

	@JsOverlay static final int SCISSOR_TEST = 0x0C11;

	@JsOverlay static final int SHADER_TYPE = 0x8B4F;

	@JsOverlay static final int SHADING_LANGUAGE_VERSION = 0x8B8C;

	@JsOverlay static final int SHORT = 0x1402;

	@JsOverlay static final int SRC_ALPHA = 0x0302;

	@JsOverlay static final int SRC_ALPHA_SATURATE = 0x0308;

	@JsOverlay static final int SRC_COLOR = 0x0300;

	@JsOverlay static final int STATIC_DRAW = 0x88E4;

	@JsOverlay static final int STENCIL_ATTACHMENT = 0x8D20;

	@JsOverlay static final int STENCIL_BACK_FAIL = 0x8801;

	@JsOverlay static final int STENCIL_BACK_FUNC = 0x8800;

	@JsOverlay static final int STENCIL_BACK_PASS_DEPTH_FAIL = 0x8802;

	@JsOverlay static final int STENCIL_BACK_PASS_DEPTH_PASS = 0x8803;

	@JsOverlay static final int STENCIL_BACK_REF = 0x8CA3;

	@JsOverlay static final int STENCIL_BACK_VALUE_MASK = 0x8CA4;

	@JsOverlay static final int STENCIL_BACK_WRITEMASK = 0x8CA5;

	@JsOverlay static final int STENCIL_BITS = 0x0D57;

	@JsOverlay static final int STENCIL_BUFFER_BIT = 0x00000400;

	@JsOverlay static final int STENCIL_CLEAR_VALUE = 0x0B91;

	@JsOverlay static final int STENCIL_FAIL = 0x0B94;

	@JsOverlay static final int STENCIL_FUNC = 0x0B92;

	@JsOverlay static final int STENCIL_INDEX = 0x1901;

	@JsOverlay static final int STENCIL_INDEX8 = 0x8D48;

	@JsOverlay static final int STENCIL_PASS_DEPTH_FAIL = 0x0B95;

	@JsOverlay static final int STENCIL_PASS_DEPTH_PASS = 0x0B96;

	@JsOverlay static final int STENCIL_REF = 0x0B97;

	@JsOverlay static final int STENCIL_TEST = 0x0B90;

	@JsOverlay static final int STENCIL_VALUE_MASK = 0x0B93;

	@JsOverlay static final int STENCIL_WRITEMASK = 0x0B98;

	@JsOverlay static final int STREAM_DRAW = 0x88E0;

	@JsOverlay static final int SUBPIXEL_BITS = 0x0D50;

	@JsOverlay static final int TEXTURE = 0x1702;

	@JsOverlay static final int TEXTURE0 = 0x84C0;

	@JsOverlay static final int TEXTURE1 = 0x84C1;

	@JsOverlay static final int TEXTURE10 = 0x84CA;

	@JsOverlay static final int TEXTURE11 = 0x84CB;

	@JsOverlay static final int TEXTURE12 = 0x84CC;

	@JsOverlay static final int TEXTURE13 = 0x84CD;

	@JsOverlay static final int TEXTURE14 = 0x84CE;

	@JsOverlay static final int TEXTURE15 = 0x84CF;

	@JsOverlay static final int TEXTURE16 = 0x84D0;

	@JsOverlay static final int TEXTURE17 = 0x84D1;

	@JsOverlay static final int TEXTURE18 = 0x84D2;

	@JsOverlay static final int TEXTURE19 = 0x84D3;

	@JsOverlay static final int TEXTURE2 = 0x84C2;

	@JsOverlay static final int TEXTURE20 = 0x84D4;

	@JsOverlay static final int TEXTURE21 = 0x84D5;

	@JsOverlay static final int TEXTURE22 = 0x84D6;

	@JsOverlay static final int TEXTURE23 = 0x84D7;

	@JsOverlay static final int TEXTURE24 = 0x84D8;

	@JsOverlay static final int TEXTURE25 = 0x84D9;

	@JsOverlay static final int TEXTURE26 = 0x84DA;

	@JsOverlay static final int TEXTURE27 = 0x84DB;

	@JsOverlay static final int TEXTURE28 = 0x84DC;

	@JsOverlay static final int TEXTURE29 = 0x84DD;

	@JsOverlay static final int TEXTURE3 = 0x84C3;

	@JsOverlay static final int TEXTURE30 = 0x84DE;

	@JsOverlay static final int TEXTURE31 = 0x84DF;

	@JsOverlay static final int TEXTURE4 = 0x84C4;

	@JsOverlay static final int TEXTURE5 = 0x84C5;

	@JsOverlay static final int TEXTURE6 = 0x84C6;

	@JsOverlay static final int TEXTURE7 = 0x84C7;

	@JsOverlay static final int TEXTURE8 = 0x84C8;

	@JsOverlay static final int TEXTURE9 = 0x84C9;

	@JsOverlay static final int TEXTURE_2D = 0x0DE1;

	@JsOverlay static final int TEXTURE_BINDING_2D = 0x8069;

	@JsOverlay static final int TEXTURE_BINDING_CUBE_MAP = 0x8514;

	@JsOverlay static final int TEXTURE_CUBE_MAP = 0x8513;

	@JsOverlay static final int TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516;

	@JsOverlay static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518;

	@JsOverlay static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851A;

	@JsOverlay static final int TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515;

	@JsOverlay static final int TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517;

	@JsOverlay static final int TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519;

	@JsOverlay static final int TEXTURE_MAG_FILTER = 0x2800;

	@JsOverlay static final int TEXTURE_MIN_FILTER = 0x2801;

	@JsOverlay static final int TEXTURE_WRAP_S = 0x2802;

	@JsOverlay static final int TEXTURE_WRAP_T = 0x2803;

	@JsOverlay static final int TRIANGLES = 0x0004;

	@JsOverlay static final int TRIANGLE_FAN = 0x0006;

	@JsOverlay static final int TRIANGLE_STRIP = 0x0005;

	@JsOverlay static final int UNPACK_ALIGNMENT = 0x0CF5;

	@JsOverlay static final int UNPACK_COLORSPACE_CONVERSION_WEBGL = 0x9243;

	@JsOverlay static final int UNPACK_FLIP_Y_WEBGL = 0x9240;

	@JsOverlay static final int UNPACK_PREMULTIPLY_ALPHA_WEBGL = 0x9241;

	@JsOverlay static final int UNSIGNED_BYTE = 0x1401;

	@JsOverlay static final int UNSIGNED_INT = 0x1405;

	@JsOverlay static final int UNSIGNED_SHORT = 0x1403;

	@JsOverlay static final int UNSIGNED_SHORT_4_4_4_4 = 0x8033;

	@JsOverlay static final int UNSIGNED_SHORT_5_5_5_1 = 0x8034;

	@JsOverlay static final int UNSIGNED_SHORT_5_6_5 = 0x8363;

	@JsOverlay static final int VALIDATE_STATUS = 0x8B83;

	@JsOverlay static final int VENDOR = 0x1F00;

	@JsOverlay static final int VERSION = 0x1F02;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886A;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_SIZE = 0x8623;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624;

	@JsOverlay static final int VERTEX_ATTRIB_ARRAY_TYPE = 0x8625;

	@JsOverlay static final int VERTEX_SHADER = 0x8B31;

	@JsOverlay static final int VIEWPORT = 0x0BA2;

	@JsOverlay static final int ZERO = 0;

	@JsMethod 
	int getDrawingBufferHeight();

	@JsMethod
	int getDrawingBufferWidth();

	@JsMethod void
	activeTexture(int texture);

	@JsMethod void
	attachShader(WebGLProgram program, WebGLShader shader);

	@JsMethod void
	bindAttribLocation(WebGLProgram program, int index, String name);

	@JsMethod void
	bindBuffer(int target, WebGLBuffer buffer);

	@JsMethod void
	bindFramebuffer(int target, WebGLFramebuffer framebuffer);

	@JsMethod void
	bindRenderbuffer(int target, WebGLRenderbuffer renderbuffer);

	@JsMethod void
	bindTexture(int target, WebGLTexture texture);

	@JsMethod void
	blendColor(float red, float green, float blue, float alpha);

	@JsMethod void
	blendEquation(int mode);

	@JsMethod void
	blendEquationSeparate(int modeRGB, int modeAlpha);

	@JsMethod void
	blendFunc(int sfactor, int dfactor);

	@JsMethod void
	blendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

	@JsMethod void
	bufferData(int target, ArrayBuffer data, int usage);

	@JsMethod void
	bufferData(int target, ArrayBufferView data, int usage);

	@JsMethod void
	bufferData(int target, double size, int usage);

	@JsMethod void
	bufferSubData(int target, double offset, ArrayBuffer data);

	@JsMethod void
	bufferSubData(int target, double offset, ArrayBufferView data);

	@JsMethod
	int checkFramebufferStatus(int target);

	@JsMethod void
	clear(int mask);

	@JsMethod void
	clearColor(float red, float green, float blue, float alpha);

	@JsMethod void
	clearDepth(float depth);

	@JsMethod void
	clearStencil(int s);

	@JsMethod void
	colorMask(boolean red, boolean green, boolean blue, boolean alpha);

	@JsMethod void
	compileShader(WebGLShader shader);

	@JsMethod void
	compressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, ArrayBufferView data);

	@JsMethod void
	compressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, ArrayBufferView data);

	@JsMethod void
	copyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

	@JsMethod void
	copyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);

	@JsMethod
	WebGLBuffer createBuffer();

	@JsMethod
	WebGLFramebuffer createFramebuffer();

	@JsMethod
	WebGLProgram createProgram();

	@JsMethod
	WebGLRenderbuffer createRenderbuffer();

	@JsMethod
	WebGLShader createShader(int type);

	@JsMethod
	WebGLTexture createTexture();

	@JsMethod void
	cullFace(int mode);

	@JsMethod void
	deleteBuffer(WebGLBuffer buffer);

	@JsMethod void
	deleteFramebuffer(WebGLFramebuffer framebuffer);

	@JsMethod void
	deleteProgram(WebGLProgram program);

	@JsMethod void
	deleteRenderbuffer(WebGLRenderbuffer renderbuffer);

	@JsMethod void
	deleteShader(WebGLShader shader);

	@JsMethod void
	deleteTexture(WebGLTexture texture);

	@JsMethod void
	depthFunc(int func);

	@JsMethod void
	depthMask(boolean flag);

	@JsMethod void
	depthRange(float zNear, float zFar);

	@JsMethod void
	detachShader(WebGLProgram program, WebGLShader shader);

	@JsMethod void
	disable(int cap);

	@JsMethod void
	disableVertexAttribArray(int index);

	@JsMethod void
	drawArrays(int mode, int first, int count);

	@JsMethod void
	drawElements(int mode, int count, int type, double offset);

	@JsMethod void
	enable(int cap);

	@JsMethod void
	enableVertexAttribArray(int index);

	@JsMethod void
	finish();

	@JsMethod void
	flush();

	@JsMethod void
	framebufferRenderbuffer(int target, int attachment, int renderbuffertarget, WebGLRenderbuffer renderbuffer);

	@JsMethod void
	framebufferTexture2D(int target, int attachment, int textarget, WebGLTexture texture, int level);

	@JsMethod void
	frontFace(int mode);

	@JsMethod void
	generateMipmap(int target);

	@JsMethod
	WebGLActiveInfo getActiveAttrib(WebGLProgram program, int index);

	@JsMethod
	WebGLActiveInfo getActiveUniform(WebGLProgram program, int index);

	@JsMethod
	JsArray<? extends WebGLShader> getAttachedShaders(WebGLProgram program);

	@JsMethod
	int getAttribLocation(WebGLProgram program, String name);

	@JsMethod
	Any getBufferParameter(int target, int pname);

	
	
	@JsMethod
	WebGLContextAttributes getContextAttributes();

	@JsMethod
	int getError();

	@JsMethod
	Object getExtension(String name);

	@JsMethod
	Any getFramebufferAttachmentParameter(int target, int attachment, int pname);

	@JsMethod
	Any getParameter(int pname);

	@JsMethod
	String getProgramInfoLog(WebGLProgram program);

	@JsMethod
	Any getProgramParameter(WebGLProgram program, int pname);

	@JsMethod
	Any getRenderbufferParameter(int target, int pname);

	@JsMethod
	String getShaderInfoLog(WebGLShader shader);

	@JsMethod
	Any getShaderParameter(WebGLShader shader, int pname);
	
	
	@JsMethod
	WebGLShaderPrecisionFormat getShaderPrecisionFormat(int shadertype, int precisiontype);

	@JsMethod
	String getShaderSource(WebGLShader shader);

	@JsMethod
	Any getTexParameter(int target, int pname);

	@JsMethod
	Any getUniform(WebGLProgram program, WebGLUniformLocation location);

	@JsMethod
	WebGLUniformLocation getUniformLocation(WebGLProgram program, String name);

	@JsMethod
	Any getVertexAttrib(int index, int pname);

	@JsMethod
	double getVertexAttribOffset(int index, int pname);

	@JsMethod void
	hint(int target, int mode);

	@JsMethod
	boolean isBuffer(WebGLBuffer buffer);

	@JsMethod
	boolean isContextLost();

	@JsMethod
	boolean isEnabled(int cap);

	@JsMethod
	boolean isFramebuffer(WebGLFramebuffer framebuffer);

	@JsMethod
	boolean isProgram(WebGLProgram program);

	@JsMethod
	boolean isRenderbuffer(WebGLRenderbuffer renderbuffer);

	@JsMethod
	boolean isShader(WebGLShader shader);

	@JsMethod
	boolean isTexture(WebGLTexture texture);

	@JsMethod void
	lineWidth(float width);

	@JsMethod void
	linkProgram(WebGLProgram program);

	@JsMethod void
	pixelStorei(int pname, int param);

	@JsMethod void
	polygonOffset(float factor, float units);

	@JsMethod void
	readPixels(int x, int y, int width, int height, int format, int type, ArrayBufferView pixels);

	@JsMethod void
	releaseShaderCompiler();

	@JsMethod void
	renderbufferStorage(int target, int internalformat, int width, int height);

	@JsMethod void
	sampleCoverage(float value, boolean invert);

	@JsMethod void
	scissor(int x, int y, int width, int height);

	@JsMethod void
	shaderSource(WebGLShader shader, String string);

	@JsMethod void
	stencilFunc(int func, int ref, int mask);

	@JsMethod void
	stencilFuncSeparate(int face, int func, int ref, int mask);

	@JsMethod void
	stencilMask(int mask);

	@JsMethod void
	stencilMaskSeparate(int face, int mask);

	@JsMethod void
	stencilOp(int fail, int zfail, int zpass);

	@JsMethod void
	stencilOpSeparate(int face, int fail, int zfail, int zpass);

	@JsMethod void
	texImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, ArrayBufferView pixels);

	@JsMethod void
	texImage2D(int target, int level, int internalformat, int format, int type, ImageData pixels);

	@JsMethod void
	texImage2D(int target, int level, int internalformat, int format, int type, ImageElement image);

	@JsMethod void
	texImage2D(int target, int level, int internalformat, int format, int type, CanvasElement canvas);

	@JsMethod void
	texImage2D(int target, int level, int internalformat, int format, int type, VideoElement video);

	@JsMethod void
	texParameterf(int target, int pname, float param);

	@JsMethod void
	texParameteri(int target, int pname, int param);

	@JsMethod void
	texSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, ArrayBufferView pixels);

	@JsMethod void
	texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageData pixels);

	@JsMethod void
	texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageElement image);

	@JsMethod void
	texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, CanvasElement canvas);

	@JsMethod void
	texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, VideoElement video);

	@JsMethod void
	uniform1f(WebGLUniformLocation location, float x);

	@JsMethod void
	uniform1fv(WebGLUniformLocation location, Float32Array v);

	@JsMethod void
	uniform1i(WebGLUniformLocation location, int x);

	@JsMethod void
	uniform1iv(WebGLUniformLocation location, Int32Array v);

	@JsMethod void
	uniform2f(WebGLUniformLocation location, float x, float y);

	@JsMethod void
	uniform2fv(WebGLUniformLocation location, Float32Array v);

	@JsMethod void
	uniform2i(WebGLUniformLocation location, int x, int y);

	@JsMethod void
	uniform2iv(WebGLUniformLocation location, Int32Array v);

	@JsMethod void
	uniform3f(WebGLUniformLocation location, float x, float y, float z);

	@JsMethod void
	uniform3fv(WebGLUniformLocation location, Float32Array v);

	@JsMethod void
	uniform3i(WebGLUniformLocation location, int x, int y, int z);

	@JsMethod void
	uniform3iv(WebGLUniformLocation location, Int32Array v);

	@JsMethod void
	uniform4f(WebGLUniformLocation location, float x, float y, float z, float w);

	@JsMethod void
	uniform4fv(WebGLUniformLocation location, Float32Array v);

	@JsMethod void
	uniform4i(WebGLUniformLocation location, int x, int y, int z, int w);

	@JsMethod void
	uniform4iv(WebGLUniformLocation location, Int32Array v);

	@JsMethod void
	uniformMatrix2fv(WebGLUniformLocation location, boolean transpose, Float32Array array);

	@JsMethod void
	uniformMatrix3fv(WebGLUniformLocation location, boolean transpose, Float32Array array);

	@JsMethod void
	uniformMatrix4fv(WebGLUniformLocation location, boolean transpose, Float32Array array);

	@JsMethod void
	useProgram(WebGLProgram program);

	@JsMethod void
	validateProgram(WebGLProgram program);

	@JsMethod void
	vertexAttrib1f(int indx, float x);

	@JsMethod void
	vertexAttrib1fv(int indx, Float32Array values);

	@JsMethod void
	vertexAttrib2f(int indx, float x, float y);

	@JsMethod void
	vertexAttrib2fv(int indx, Float32Array values);

	@JsMethod void
	vertexAttrib3f(int indx, float x, float y, float z);

	@JsMethod void
	vertexAttrib3fv(int indx, Float32Array values);

	@JsMethod void
	vertexAttrib4f(int indx, float x, float y, float z, float w);

	@JsMethod void
	vertexAttrib4fv(int indx, Float32Array values);

	@JsMethod void
	vertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, double offset);

	@JsMethod void
	viewport(int x, int y, int width, int height);
}
