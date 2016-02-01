package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.media.client.Video;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtwebgl.client.WebGL;
import com.googlecode.gwtwebgl.html.WebGLContextAttributes;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.jooink.experiments.gwtwebgl.client.Matrices;
import com.jooink.experiments.gwtwebgl.client.Test;
import com.jooink.experiments.gwtwebgl.client.Webgl_sample.Console;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LessTrivial extends Test {


	@Override
	public String getName() {
		return "LessTrivial";
	}

	public interface BackgroundVideo extends ClientBundle {
		@Source("me_and_hiro.mov")
		@DoNotEmbed
		public DataResource captured_video_m4v();

		@Source("me_and_hiro.webm")
		@DoNotEmbed
		public DataResource captured_video_webm();
	}


	private static final BackgroundVideo backgroundVideo = GWT.create(BackgroundVideo.class);


	@Override
	public void execute(HasWidgets.ForIsWidget cont, EventBus bus) {



		final Video video = Video.createIfSupported();

		video.addSource(backgroundVideo.captured_video_m4v().getSafeUri().asString());
		video.addSource(backgroundVideo.captured_video_webm().getSafeUri().asString());
		video.setControls(false);
		video.setAutoplay(true);
		video.setLoop(true);


		Canvas canvas = Canvas.createIfSupported();

		cont.clear();
		cont.add(canvas);

		WebGLContextAttributes att = WebGL.createAttributes();
		att.setPreserveDrawingBuffer(false);
		final WebGLRenderingContext ctx = WebGL.getContext(canvas, att);


		

		CanvasElement canvasElement =  canvas.getCanvasElement();

		canvasElement.setWidth(640);
		canvasElement.setHeight(480);

		ctx.viewport(0, 0, 640, 360);



		//ctx.enable(WebGLRenderingContext.DEPTH_TEST);
		//ctx.depthFunc(WebGLRenderingContext.LEQUAL); 


		final Scene scene = new BasicScene(ctx,video.getVideoElement(), 640, 480);
		scene.setMatrix(  Matrices.perspectiveMatrix(40,640.0f/480.0f, 0.1f, 1000.0f) );
		scene.pushMatrix( Matrices.lookaAtMatrix(new float[] {3.5f,3.5f,4.0f} , new float[]{0,0,1},new float[]{0,0,1}) );

		final Shape shape1 = new Cube(ctx, Matrices.translate(Matrices.scaleMatrix(new float[]{0.5f,0.5f,0.5f,0.5f}),new float[]{1.2f,0,0,0}));
		shape1.setVisible();

		scene.addShape(shape1);
		
		final Shape shape2 = new FlowerCube(ctx, Matrices.translate(Matrices.scaleMatrix(new float[]{0.5f,0.5f,0.5f,0.5f}),new float[]{1.2f,0,0,0}));
		shape2.setVisible();

		scene.addShape(shape2);


		Timer timer = new Timer() {
			@Override
			public void run() {
				if(video.getReadyState() >0) {
					//shape1.rotate(0.04f, 1,0,0);
					shape1.translate(1.2f,0,0,0);
					shape1.rotate(0.03f, 0,0,1);
					shape1.translate(-1.2f,0,0,0);

					shape2.translate(-1.2f,0,0,0);
					shape2.rotate(0.03f, 0,0,1);
					//shape2.rotate(-0.04f, 0,1,0);
					shape2.translate(1.2f,0,0,0);

					scene.draw();
				}
			}
		};



		timer.scheduleRepeating(10);



	}



	@Override
	public void stop() {
	}







}
