package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;

import java.util.Date;

import com.google.gwt.typedarrays.shared.Float32Array;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.jooink.experiments.gwtwebgl.client.Matrices;
import com.jooink.experiments.gwtwebgl.client.Utils;

public abstract class CopyOfShape {

	private long birthTime = 0;

		
	protected abstract void draw(WebGLRenderingContext ctx3d, Float32Array mvMatrix, Float32Array perspectiveMatrix,float timeFromCreationInseconds);

	private WebGLRenderingContext ctx3d;
	protected WebGLRenderingContext _getContext() {
		return ctx3d;
	}
	
	private float[] tMatrix = Matrices.identity();  //transformation matrix (scene default pos 2 actual pos)
	private float[] msMatrix; //model 2 scene matrix, if exists is premultiplied with any transformations matrix
	private Float32Array currentMatrix; //ms * t

	public CopyOfShape(WebGLRenderingContext ctx3d) {
		this(ctx3d,null);
	}
	
	public CopyOfShape(WebGLRenderingContext ctx3d, float... model2SceneMatrix) {
		this.ctx3d = ctx3d;
		this.msMatrix= model2SceneMatrix;
		setupCurrentMatrix();	
	}
	
	
	private void setupCurrentMatrix() {
		float[] cm;
		if(msMatrix==null)
			if(tMatrix==null)
				cm = Matrices.identity();
			else 
				cm = tMatrix;
		else
			if(tMatrix==null)
				cm = msMatrix;
			else 
				cm = Matrices.multiply(msMatrix, tMatrix);
		
		currentMatrix = Utils.Float32ArrayfromFloatArray(cm);
		
	}
	
	
	public void draw(float[] perspectiveMatrix) {
		if(birthTime<=0)
			birthTime=(new Date()).getTime();		
		
		
		draw(ctx3d,currentMatrix, Utils.Float32ArrayfromFloatArray( perspectiveMatrix ), (float)(((double)(birthTime-(new Date()).getTime()))/1000.0d));
			
	}
	
	public void resetTime() {
		birthTime=0;
	}
	
	
	
	
	private boolean visible = false;
	public boolean isVisible() {
		return visible;
	}	

	
	/*
	 * reset passing null Arghhhh
	 */
	public void setTransformation(float... tMatrix) {
		this.tMatrix = tMatrix;
		setupCurrentMatrix();

	}

	public void rotate(float angle, float... axis) {
		float[] m = this.tMatrix;
		this.tMatrix = Matrices.rotate(m,angle,axis);
		setupCurrentMatrix();
	}

	public void translate(float... vec) {
		float[] m = this.tMatrix;
		this.tMatrix = Matrices.translate(m,vec);
		setupCurrentMatrix();
	}

	public void scale(float... s) {
		float[] m = this.tMatrix;
		this.tMatrix = Matrices.scale(m,s);
		setupCurrentMatrix();
	}
	
	
	
	public void setVisible() {
		this.visible = true;
	}
	
	public void setNotVisible() {
		this.visible = false;
	}
	
}