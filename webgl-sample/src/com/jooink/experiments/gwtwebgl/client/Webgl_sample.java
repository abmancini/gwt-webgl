package com.jooink.experiments.gwtwebgl.client;

import java.util.Arrays;
import java.util.List;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jooink.experiments.gwtwebgl.client.tests.cube.SimpleCube;
import com.jooink.experiments.gwtwebgl.client.tests.julia.Julia;
import com.jooink.experiments.gwtwebgl.client.tests.lesstrivial.LessTrivial;
import com.jooink.experiments.gwtwebgl.client.tests.params.Params;
import com.jooink.experiments.gwtwebgl.client.tests.preservebuffer.PreserveDrawingBuffer;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Webgl_sample implements EntryPoint {

	
	@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="console")
	final static public class Console {
		public static native void log(Object ms);
	}

	List<Test> tests = Arrays.asList( /*new LessTrivial(),*/new Julia(),new Params(), new PreserveDrawingBuffer(), new SimpleCube());
	
	@Override
	public void onModuleLoad() {
				

		final ListBox list = new ListBox();
		for(Test t : tests) {
			list.addItem(t.getName());
		}
		
		list.setSelectedIndex(0);
		
		RootPanel.get("list").add(list);
		
		
		//WebGLRenderingContext ctx = (JsWebGLRenderingContext) canvas.getCanvasElement().getContext("experimental-webgl");

		
		
		final EventBus bus = new SimpleEventBus();

		
		//Test t = new LessTrivial();//		
		//Test t = new Julia();

		
		tests.get(0).execute(RootPanel.get("tests"), bus);
		
		list.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				tests.get(list.getSelectedIndex()).execute(RootPanel.get("tests"), bus);
			}
		});
	}
	
	
	
	
}