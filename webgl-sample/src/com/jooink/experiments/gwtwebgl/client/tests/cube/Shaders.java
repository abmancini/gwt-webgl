package com.jooink.experiments.gwtwebgl.client.tests.cube;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

interface Shaders extends ClientBundle {

    public static Shaders INSTANCE = GWT.create(Shaders.class);

    @Source("vertexShader.txt")

    public TextResource vertexShader();

    @Source("fragmentShader.txt")

    public TextResource fragmentShader();

}