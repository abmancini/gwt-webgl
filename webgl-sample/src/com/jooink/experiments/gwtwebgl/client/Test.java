package com.jooink.experiments.gwtwebgl.client;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;

public abstract class Test {

	public abstract void execute(HasWidgets.ForIsWidget cont, EventBus bus);
	
	public abstract void stop();

	public abstract String getName();
}
