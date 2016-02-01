package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;



import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.jooink.experiments.gwtwebgl.client.Matrices;
import com.jooink.experiments.gwtwebgl.client.Utils;

public class CleanScene extends Scene {

	
	//private int w,h;


	
	public CleanScene(WebGLRenderingContext ctx,int w, int h) {
		super(ctx);

//		this.w = w;
//		this.h = h;


		//prepare ctx for shapes
		 this.setMatrix(  Matrices.perspectiveMatrix(40,(float)w / (float)h, 0.1f, 1000.0f) );
		ctx.enable(WebGLRenderingContext.DEPTH_TEST); //Enable Depth Testing      
		ctx.depthFunc(WebGLRenderingContext.LEQUAL); //Set Perspective View       
		ctx.viewport(0, 0, w, h);



	}

	@Override
	public void draw() {
//
//		if(had_resize) {
//			had_resize=false;
//			ctx3d.viewport(0, 0, w, h);
//			ctx3d.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPositionBuffer);
//			ArrayBufferView rect = createRectangleVertices( 0, 0,w,h);
//			ctx3d.bufferData(WebGLRenderingContext.ARRAY_BUFFER, rect , WebGLRenderingContext.STATIC_DRAW);
//		}

		WebGLRenderingContext ctx3d = this.getContext();
		Utils.clear(ctx3d);

		ctx3d.clear(WebGLRenderingContext.COLOR_BUFFER_BIT|WebGLRenderingContext.DEPTH_BUFFER_BIT);      // Clear the color as well as the depth buffer.

		//now draw all the shapes

		drawShapes();
		
		//finished 
		ctx3d.flush();


	}


}