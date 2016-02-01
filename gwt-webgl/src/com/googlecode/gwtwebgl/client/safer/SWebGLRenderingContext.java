package com.googlecode.gwtwebgl.client.safer;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.typedarrays.shared.Float32Array;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;

public class SWebGLRenderingContext {
	private WebGLRenderingContext ctx;


	public static final Parameters.GetParamReturningGLint ALPHA_BITS = Parameters.GetParamReturningGLint.ALPHA_BITS;
	public static final Parameters.GetParamReturningFloat32Array ALIASED_LINE_WIDTH_RANGE = Parameters.GetParamReturningFloat32Array.ALIASED_LINE_WIDTH_RANGE;
	public static final Parameters.GetParamReturningFloat32Array ALIASED_POINT_SIZE_RANGE = Parameters.GetParamReturningFloat32Array.ALIASED_POINT_SIZE_RANGE;
	public static final Parameters.GetParamReturningString VERSION = Parameters.GetParamReturningString.VERSION;



	public SWebGLRenderingContext(WebGLRenderingContext ctx) {
		this.ctx = ctx;
	}


	public Float32Array getParameter(Parameters.GetParamReturningFloat32Array p) {
		return ctx.getParameter(p.v).getFloat32Array();
	}

	public int getParameter(Parameters.GetParamReturningGLint p) {
		return ctx.getParameter(p.v).getInt();
	}
	public String getParameter(Parameters.GetParamReturningString p) {
		return ctx.getParameter(p.v).getString();
	}


	public static void testApi() {

		Canvas canvas = Canvas.createIfSupported();
		WebGLRenderingContext ctx3d = WebGL.getContext(canvas);

		SWebGLRenderingContext sctx = new SWebGLRenderingContext(ctx3d);


		 String res = sctx.getParameter(SWebGLRenderingContext.VERSION);

		 System.out.println(res);
	}


}
