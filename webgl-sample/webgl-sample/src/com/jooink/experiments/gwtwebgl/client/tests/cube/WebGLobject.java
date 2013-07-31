package com.jooink.experiments.gwtwebgl.client.tests.cube;

import com.google.gwt.typedarrays.shared.Float32Array;
import com.google.gwt.typedarrays.shared.Uint16Array;


public interface WebGLobject {

	public Float32Array getVerticesArray();

	public Uint16Array getIndexesArray();

	public int getNumIndices();

	public Float32Array getTextureCoordinatesArray();

	public Float32Array getNormalsArray();

}