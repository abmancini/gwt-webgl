package com.jooink.experiments.gwtwebgl.client.tests.params;


import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.googlecode.gwtwebgl.utils.Any;
import com.jooink.experiments.gwtwebgl.client.Test;

public class Params extends Test {

	VerticalPanel list = new VerticalPanel();
	WebGLRenderingContext ctx;
	@Override
	public void execute(ForIsWidget cont, EventBus bus) {

		cont.clear();
		cont.add(list);
		
		Canvas canvas = Canvas.createIfSupported();
		
		cont.clear();
		cont.add(list);
		
		ctx = WebGL.getContext(canvas);

		CanvasElement canvasElement =  canvas.getCanvasElement();

		canvasElement.setWidth(64);
		canvasElement.setHeight(48);

		ctx.viewport(0, 0, 64, 48);

		list.add(canvas); //empty
		
		tryParam(WebGLRenderingContext.ALIASED_LINE_WIDTH_RANGE,"ALIASED_LINE_WIDTH_RANGE","Float32Array (with 2 elements)");
		tryParam(WebGLRenderingContext.ALIASED_POINT_SIZE_RANGE,"ALIASED_POINT_SIZE_RANGE","Float32Array (with 2 elements)");
		tryParam(WebGLRenderingContext.ALPHA_BITS,"ALPHA_BITS","GLint");
		tryParam(WebGLRenderingContext.ARRAY_BUFFER_BINDING,"ARRAY_BUFFER_BINDING","WebGLBuffer");
		tryParam(WebGLRenderingContext.BLEND,"BLEND","GLboolean");
		tryParam(WebGLRenderingContext.BLEND_COLOR,"BLEND_COLOR","Float32Array (with 4 values)");
		tryParam(WebGLRenderingContext.BLEND_DST_ALPHA,"BLEND_DST_ALPHA","GLenum");
		tryParam(WebGLRenderingContext.BLEND_DST_RGB,"BLEND_DST_RGB","GLenum");
		tryParam(WebGLRenderingContext.BLEND_EQUATION_ALPHA,"BLEND_EQUATION_ALPHA","GLenum");
		tryParam(WebGLRenderingContext.BLEND_EQUATION_RGB,"BLEND_EQUATION_RGB","GLenum");
		tryParam(WebGLRenderingContext.BLEND_SRC_ALPHA,"BLEND_SRC_ALPHA","GLenum");
		tryParam(WebGLRenderingContext.BLEND_SRC_RGB,"BLEND_SRC_RGB","GLenum");
		tryParam(WebGLRenderingContext.BLUE_BITS,"BLUE_BITS","GLint");
		tryParam(WebGLRenderingContext.COLOR_CLEAR_VALUE,"COLOR_CLEAR_VALUE","Float32Array (with 4 values)");
		tryParam(WebGLRenderingContext.COLOR_WRITEMASK,"COLOR_WRITEMASK","sequence<GLboolean> (with 4 values)");
		tryParam(WebGLRenderingContext.COMPRESSED_TEXTURE_FORMATS,"COMPRESSED_TEXTURE_FORMATS","Uint32Array");
		tryParam(WebGLRenderingContext.CULL_FACE,"CULL_FACE","GLboolean");
		tryParam(WebGLRenderingContext.CULL_FACE_MODE,"CULL_FACE_MODE","GLenum");
		tryParam(WebGLRenderingContext.CURRENT_PROGRAM,"CURRENT_PROGRAM","WebGLProgram");
		tryParam(WebGLRenderingContext.DEPTH_BITS,"DEPTH_BITS","GLint");
		tryParam(WebGLRenderingContext.DEPTH_CLEAR_VALUE,"DEPTH_CLEAR_VALUE","GLfloat");
		tryParam(WebGLRenderingContext.DEPTH_FUNC,"DEPTH_FUNC","GLenum");
		tryParam(WebGLRenderingContext.DEPTH_RANGE,"DEPTH_RANGE","Float32Array (with 2 elements)");
		tryParam(WebGLRenderingContext.DEPTH_TEST,"DEPTH_TEST","GLboolean");
		tryParam(WebGLRenderingContext.DEPTH_WRITEMASK,"DEPTH_WRITEMASK","GLboolean");
		tryParam(WebGLRenderingContext.DITHER,"DITHER","GLboolean");
		tryParam(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER_BINDING,"ELEMENT_ARRAY_BUFFER_BINDING","WebGLBuffer");
		tryParam(WebGLRenderingContext.FRAMEBUFFER_BINDING,"FRAMEBUFFER_BINDING","WebGLFramebuffer");
		tryParam(WebGLRenderingContext.FRONT_FACE,"FRONT_FACE","GLenum");
		tryParam(WebGLRenderingContext.GENERATE_MIPMAP_HINT,"GENERATE_MIPMAP_HINT","GLenum");
		tryParam(WebGLRenderingContext.GREEN_BITS,"GREEN_BITS","GLint");
		tryParam(WebGLRenderingContext.LINE_WIDTH,"LINE_WIDTH","GLfloat");
		tryParam(WebGLRenderingContext.MAX_COMBINED_TEXTURE_IMAGE_UNITS,"MAX_COMBINED_TEXTURE_IMAGE_UNITS","GLint");
		tryParam(WebGLRenderingContext.MAX_CUBE_MAP_TEXTURE_SIZE,"MAX_CUBE_MAP_TEXTURE_SIZE","GLint");
		tryParam(WebGLRenderingContext.MAX_FRAGMENT_UNIFORM_VECTORS,"MAX_FRAGMENT_UNIFORM_VECTORS","GLint");
		tryParam(WebGLRenderingContext.MAX_RENDERBUFFER_SIZE,"MAX_RENDERBUFFER_SIZE","GLint");
		tryParam(WebGLRenderingContext.MAX_TEXTURE_IMAGE_UNITS,"MAX_TEXTURE_IMAGE_UNITS","GLint");
		tryParam(WebGLRenderingContext.MAX_TEXTURE_SIZE,"MAX_TEXTURE_SIZE","GLint");
		tryParam(WebGLRenderingContext.MAX_VARYING_VECTORS,"MAX_VARYING_VECTORS","GLint");
		tryParam(WebGLRenderingContext.MAX_VERTEX_ATTRIBS,"MAX_VERTEX_ATTRIBS","GLint");
		tryParam(WebGLRenderingContext.MAX_VERTEX_TEXTURE_IMAGE_UNITS,"MAX_VERTEX_TEXTURE_IMAGE_UNITS","GLint");
		tryParam(WebGLRenderingContext.MAX_VERTEX_UNIFORM_VECTORS,"MAX_VERTEX_UNIFORM_VECTORS","GLint");
		tryParam(WebGLRenderingContext.MAX_VIEWPORT_DIMS,"MAX_VIEWPORT_DIMS","Int32Array (with 2 elements)");
		tryParam(WebGLRenderingContext.PACK_ALIGNMENT,"PACK_ALIGNMENT","GLint");
		tryParam(WebGLRenderingContext.POLYGON_OFFSET_FACTOR,"POLYGON_OFFSET_FACTOR","GLfloat");
		tryParam(WebGLRenderingContext.POLYGON_OFFSET_FILL,"POLYGON_OFFSET_FILL","GLboolean");
		tryParam(WebGLRenderingContext.POLYGON_OFFSET_UNITS,"POLYGON_OFFSET_UNITS","GLfloat");
		tryParam(WebGLRenderingContext.RED_BITS,"RED_BITS","GLint");
		tryParam(WebGLRenderingContext.RENDERBUFFER_BINDING,"RENDERBUFFER_BINDING","WebGLRenderbuffer");
		tryParam(WebGLRenderingContext.RENDERER,"RENDERER","DOMString");
		tryParam(WebGLRenderingContext.SAMPLE_BUFFERS,"SAMPLE_BUFFERS","GLint");
		tryParam(WebGLRenderingContext.SAMPLE_COVERAGE_INVERT,"SAMPLE_COVERAGE_INVERT","GLboolean");
		tryParam(WebGLRenderingContext.SAMPLE_COVERAGE_VALUE,"SAMPLE_COVERAGE_VALUE","GLfloat");
		tryParam(WebGLRenderingContext.SAMPLES,"SAMPLES","GLint");
		tryParam(WebGLRenderingContext.SCISSOR_BOX,"SCISSOR_BOX","Int32Array (with 4 elements)");
		tryParam(WebGLRenderingContext.SCISSOR_TEST,"SCISSOR_TEST","GLboolean");
		tryParam(WebGLRenderingContext.SHADING_LANGUAGE_VERSION,"SHADING_LANGUAGE_VERSION","DOMString");
		tryParam(WebGLRenderingContext.STENCIL_BACK_FAIL,"STENCIL_BACK_FAIL","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_BACK_FUNC,"STENCIL_BACK_FUNC","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_BACK_PASS_DEPTH_FAIL,"STENCIL_BACK_PASS_DEPTH_FAIL","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_BACK_PASS_DEPTH_PASS,"STENCIL_BACK_PASS_DEPTH_PASS","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_BACK_REF,"STENCIL_BACK_REF","GLint");
		tryParam(WebGLRenderingContext.STENCIL_BACK_VALUE_MASK,"STENCIL_BACK_VALUE_MASK","GLuint");
		tryParam(WebGLRenderingContext.STENCIL_BACK_WRITEMASK,"STENCIL_BACK_WRITEMASK","GLuint");
		tryParam(WebGLRenderingContext.STENCIL_BITS,"STENCIL_BITS","GLint");
		tryParam(WebGLRenderingContext.STENCIL_CLEAR_VALUE,"STENCIL_CLEAR_VALUE","GLint");
		tryParam(WebGLRenderingContext.STENCIL_FAIL,"STENCIL_FAIL","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_FUNC,"STENCIL_FUNC","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_PASS_DEPTH_FAIL,"STENCIL_PASS_DEPTH_FAIL","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_PASS_DEPTH_PASS,"STENCIL_PASS_DEPTH_PASS","GLenum");
		tryParam(WebGLRenderingContext.STENCIL_REF,"STENCIL_REF","GLint");
		tryParam(WebGLRenderingContext.STENCIL_TEST,"STENCIL_TEST","GLboolean");
		tryParam(WebGLRenderingContext.STENCIL_VALUE_MASK,"STENCIL_VALUE_MASK","GLuint");
		tryParam(WebGLRenderingContext.STENCIL_WRITEMASK,"STENCIL_WRITEMASK","GLuint");
		tryParam(WebGLRenderingContext.SUBPIXEL_BITS,"SUBPIXEL_BITS","GLint");
		tryParam(WebGLRenderingContext.TEXTURE_BINDING_2D,"TEXTURE_BINDING_2D","WebGLTexture");
		tryParam(WebGLRenderingContext.TEXTURE_BINDING_CUBE_MAP,"TEXTURE_BINDING_CUBE_MAP","WebGLTexture");
		tryParam(WebGLRenderingContext.UNPACK_ALIGNMENT,"UNPACK_ALIGNMENT","GLint");
		tryParam(WebGLRenderingContext.UNPACK_COLORSPACE_CONVERSION_WEBGL,"UNPACK_COLORSPACE_CONVERSION_WEBGL","GLenum");
		tryParam(WebGLRenderingContext.UNPACK_FLIP_Y_WEBGL,"UNPACK_FLIP_Y_WEBGL","GLboolean");
		tryParam(WebGLRenderingContext.UNPACK_PREMULTIPLY_ALPHA_WEBGL,"UNPACK_PREMULTIPLY_ALPHA_WEBGL","GLboolean");
		tryParam(WebGLRenderingContext.VENDOR,"VENDOR","DOMString");
		tryParam(WebGLRenderingContext.VERSION,"VERSION","DOMString");
		tryParam(42,"error, pname=42","error");

	}

	private void tryParam(int pname, String name, String expected) {
		
		Any a = ctx.getParameter(pname);
		HTML html = new HTML();

		String natively = nativelyGetParam(ctx, pname);
		if(pname == WebGLRenderingContext.COLOR_WRITEMASK)
			html.setHTML( "<b style=\"color:blue;\">"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getJsArrayBoolean());
		else if("GLint".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getInt());
		else if("GLboolean".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getBoolean());
		else if("GLenum".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getInt());
		else if("GLfloat".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getFloat());
		else if("GLuint".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getDouble());
		else if("DOMString".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.get());
		else if("WebGLBuffer".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getWebGLBuffer());
		else if("WebGLFramebuffer".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getWebGLFramebuffer());
		else if("WebGLRenderbuffer".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getWebGLRenderbuffer());
		else if("WebGLTexture".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getWebGLTexture());
		else if("WebGLProgram".equals(expected))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getWebGLProgram());
		else if(expected.startsWith("Float32Array"))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getFloat32Array());
		else if(expected.startsWith("Uint32Array"))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getUint32Array());
		else if(expected.startsWith("Int32Array"))
			html.setHTML( "<b>"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a.getInt32Array());
		else
			html.setHTML( "<b style=\"color:red;\">"+ name + "</b>" + " ["+expected+"] {" +natively +"} " + a);
		
		list.add(html);
	}

	
	private native String nativelyGetParam(WebGLRenderingContext ctx, int pname) /*-{
		var r =  ctx.getParameter(pname)
		return '' + r + " [<b>" + (typeof r) + "</b> isA:" + Array.isArray(r) + "]";
	}-*/;
	
	
	private Float32Array getParameter_ALIASED_LINE_WIDTH_RANGE(WebGLRenderingContext ctx) {
		return ctx.getParameter(WebGLRenderingContext.ALIASED_LINE_WIDTH_RANGE).getFloat32Array();
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Parameters";
	}

}
