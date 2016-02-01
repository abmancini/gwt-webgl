package com.jooink.experiments.gwtwebgl.client.tests.lesstrivial;

import java.util.Date;

import com.google.gwt.typedarrays.shared.Float32Array;
import com.googlecode.gwtwebgl.html.WebGLRenderingContext;
import com.jooink.experiments.gwtwebgl.client.Matrices;
import com.jooink.experiments.gwtwebgl.client.Utils;

public abstract class Shape {

	private long birthTime = 0;

		
	protected abstract void draw(WebGLRenderingContext ctx3d, Float32Array mvMatrix, Float32Array perspectiveMatrix,float timeFromCreationInseconds);

	private WebGLRenderingContext ctx3d;
	
	private float[] matrix ; //transformation matrix (scene default pos 2 actual pos)
	private Float32Array currentMatrix; //ms * t
	private float[] baseTransformaton ; //transformation matrix (scene default pos 2 actual pos)

	public Shape(WebGLRenderingContext ctx3d) {
		this(ctx3d,null);
	}
	
	public Shape(WebGLRenderingContext ctx3d, float... model2SceneMatrix) {
		this.ctx3d = ctx3d;
		if(model2SceneMatrix!= null) 	
			this.matrix= model2SceneMatrix;
		else
			this.matrix = Matrices.identity();
		baseTransformaton = this.matrix; 
		setupCurrentMatrix();	
	}
	
	
	private void setupCurrentMatrix() {
		currentMatrix = Utils.Float32ArrayfromFloatArray(matrix);		
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

	
	public void setTransformation(float... tMatrix) {
		this.matrix = Matrices.multiply(baseTransformaton,tMatrix);
		setupCurrentMatrix();
	}

	public void rotate(float angle, float... axis) {
		float[] m = this.matrix;
		this.matrix = Matrices.rotate(m,angle,axis);
		setupCurrentMatrix();
	}

	public void translate(float... vec) {
		float[] m = this.matrix;
		this.matrix = Matrices.translate(m,vec);
		setupCurrentMatrix();
	}

	public void scale(float... s) {
		float[] m = this.matrix;
		this.matrix = Matrices.scale(m,s);
		setupCurrentMatrix();
	}
	
	
	
	public void setVisible() {
		this.visible = true;
	}
	
	public void setNotVisible() {
		this.visible = false;
	}
	
}