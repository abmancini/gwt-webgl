package com.jooink.experiments.gwtwebgl.client.tests.cube;


//QnD js->java from from https://github.com/toji/gl-matrix

public class Matrices {
	/*
	 * float[] perspective
	 * Generates a perspective projection matrix with the given bounds
	 *
	 * Params:
	 * fovy - scalar, vertical field of view
	 * aspect - scalar, aspect ratio. typically viewport width/height
	 * near, far - scalar, near and far bounds of the frustum
	 * dest - Optional, mat4 frustum matrix will be written into
	 *
	 * Returns:
	 * dest if specified, a new mat4 otherwise
	 */
	public static float[] 
	                     perspectiveMatrix(float fovy, float aspect, 
	                    		 float near, float far) {
		float top =(float) (near*Math.tan(fovy*Math.PI / 360.0));
		float right = top*aspect;
		return frustumMatrix(-right, right, -top, top, near, far);
	};

	/*
	 * float[] frustum
	 * Generates a frustum matrix with the given bounds
	 *
	 * Params:
	 * left, right - scalar, left and right bounds of the frustum
	 * bottom, top - scalar, bottom and top bounds of the frustum
	 * near, far - scalar, near and far bounds of the frustum
	 * dest - Optional, mat4 frustum matrix will be written into
	 *
	 * Returns:
	 * dest if specified, a new mat4 otherwise
	 */
	public static float[] 
	                     frustumMatrix(float left, float right, 
	                    		 float bottom, float top, 
	                    		 float near, float far) {

		float dest[] = new float[16];
		float rl = (right - left);
		float tb = (top - bottom);
		float fn = (far - near);
		dest[0] = (near*2.0f) / rl;
		dest[1] = 0.0f;
		dest[2] = 0.0f;
		dest[3] = 0.0f;
		dest[4] = 0.0f;
		dest[5] = (near*2.0f) / tb;
		dest[6] = 0.0f;
		dest[7] = 0.0f;
		dest[8] = (right + left) / rl;
		dest[9] = (top + bottom) / tb;
		dest[10] = -(far + near) / fn;
		dest[11] = -1.0f;
		dest[12] = 0.0f;
		dest[13] = 0.0f;
		dest[14] = -(far*near*2.0f) / fn;
		dest[15] = 0.0f;
		return dest;
	}



	/*
	 * float[] lookAt
	 * Generates a look-at matrix with the given eye position, focal point, and up axis
	 *
	 * Params:
	 * eye - vec3, position of the viewer
	 * center - vec3, point the viewer is looking at
	 * up - vec3 pointing "up"
	 * dest - Optional, mat4 frustum matrix will be written into
	 *
	 * Returns:
	 * dest if specified, a new mat4 otherwise
	 */

	public static  float[] lookaAtMatrix(float[] eye, float[] center, float[] up) {
		float eyex = eye[0];
		float eyey = eye[1];
		float eyez = eye[2];
		float upx = up[0];
		float upy = up[1];
		float upz = up[2];

		float z0,z1,z2,x0,x1,x2,y0,y1,y2,len;

		//vec3.direction(eye, center, z);
		z0 = eyex - center[0];
		z1 = eyey - center[1];
		z2 = eyez - center[2];

		// normalize (no check needed for 0 because of early return)
		len = (float)(1.0/Math.sqrt(z0*z0 + z1*z1 + z2*z2));
		z0 *= len;
		z1 *= len;
		z2 *= len;

		//vec3.normalize(vec3.cross(up, z, x));
		x0 = upy*z2 - upz*z1;
		x1 = upz*z0 - upx*z2;
		x2 = upx*z1 - upy*z0;
		len = (float)(Math.sqrt(x0*x0 + x1*x1 + x2*x2));
		if (len==0) {
			x0 = 0;
			x1 = 0;
			x2 = 0;
		} else {
			len = 1.0f/len;
			x0 *= len;
			x1 *= len;
			x2 *= len;
		};

		//vec3.normalize(vec3.cross(z, x, y));
		y0 = z1*x2 - z2*x1;
		y1 = z2*x0 - z0*x2;
		y2 = z0*x1 - z1*x0;

		len = (float)Math.sqrt(y0*y0 + y1*y1 + y2*y2);
		if (len==0) {
			y0 = 0;
			y1 = 0;
			y2 = 0;
		} else {
			len = 1.0f/len;
			y0 *= len;
			y1 *= len;
			y2 *= len;
		}

		float[] dest = new float[16];
		dest[0] = x0;
		dest[1] = y0;
		dest[2] = z0;
		dest[3] = 0.0f;
		dest[4] = x1;
		dest[5] = y1;
		dest[6] = z1;
		dest[7] = 0.0f;
		dest[8] = x2;
		dest[9] = y2;
		dest[10] = z2;
		dest[11] = 0.0f;
		dest[12] = -(x0*eyex + x1*eyey + x2*eyez);
		dest[13] = -(y0*eyex + y1*eyey + y2*eyez);
		dest[14] = -(z0*eyex + z1*eyey + z2*eyez);
		dest[15] = 1.0f;

		return dest;
	}



	/*
	 * float[] transpose
	 * Transposes a mat4 (flips the values over the diagonal)
	 *
	 * Params:
	 * mat - mat4 to transpose
	 * dest - Optional, mat4 receiving transposed values. If not specified result is written to mat
	 *
	 * Returns:
	 * dest is specified, mat otherwise
	 */
	public static float[] transpose(float[] mat) {
		float[]	dest = new float[16]; 
		dest[0] = mat[0];
		dest[1] = mat[4];
		dest[2] = mat[8];
		dest[3] = mat[12];
		dest[4] = mat[1];
		dest[5] = mat[5];
		dest[6] = mat[9];
		dest[7] = mat[13];
		dest[8] = mat[2];
		dest[9] = mat[6];
		dest[10] = mat[10];
		dest[11] = mat[14];
		dest[12] = mat[3];
		dest[13] = mat[7];
		dest[14] = mat[11];
		dest[15] = mat[15];
		return dest;
	};


	/*
	 * float[] inverse
	 * Calculates the inverse matrix of a mat4
	 *
	 * Params:
	 * mat - mat4 to calculate inverse of
	 * dest - Optional, mat4 receiving inverse matrix. If not specified result is written to mat
	 *
	 * Returns:
	 * dest is specified, mat otherwise
	 */
	public static float[] inverseMatrix(float[] mat) {

		float[] dest = new float[16];

		// Cache the matrix values (makes for huge speed increases!)
		float a00 = mat[0], a01 = mat[1], a02 = mat[2], a03 = mat[3];
		float a10 = mat[4], a11 = mat[5], a12 = mat[6], a13 = mat[7];
		float a20 = mat[8], a21 = mat[9], a22 = mat[10], a23 = mat[11];
		float a30 = mat[12], a31 = mat[13], a32 = mat[14], a33 = mat[15];

		float b00 = a00*a11 - a01*a10;
		float b01 = a00*a12 - a02*a10;
		float b02 = a00*a13 - a03*a10;
		float b03 = a01*a12 - a02*a11;
		float b04 = a01*a13 - a03*a11;
		float b05 = a02*a13 - a03*a12;
		float b06 = a20*a31 - a21*a30;
		float b07 = a20*a32 - a22*a30;
		float b08 = a20*a33 - a23*a30;
		float b09 = a21*a32 - a22*a31;
		float b10 = a21*a33 - a23*a31;
		float b11 = a22*a33 - a23*a32;

		// Calculate the determinant (inlined to avoid float-caching)
		float invDet = 1.0f/(b00*b11 - b01*b10 + b02*b09 + b03*b08 - b04*b07 + b05*b06);

		dest[0] = (a11*b11 - a12*b10 + a13*b09)*invDet;
		dest[1] = (-a01*b11 + a02*b10 - a03*b09)*invDet;
		dest[2] = (a31*b05 - a32*b04 + a33*b03)*invDet;
		dest[3] = (-a21*b05 + a22*b04 - a23*b03)*invDet;
		dest[4] = (-a10*b11 + a12*b08 - a13*b07)*invDet;
		dest[5] = (a00*b11 - a02*b08 + a03*b07)*invDet;
		dest[6] = (-a30*b05 + a32*b02 - a33*b01)*invDet;
		dest[7] = (a20*b05 - a22*b02 + a23*b01)*invDet;
		dest[8] = (a10*b10 - a11*b08 + a13*b06)*invDet;
		dest[9] = (-a00*b10 + a01*b08 - a03*b06)*invDet;
		dest[10] = (a30*b04 - a31*b02 + a33*b00)*invDet;
		dest[11] = (-a20*b04 + a21*b02 - a23*b00)*invDet;
		dest[12] = (-a10*b09 + a11*b07 - a12*b06)*invDet;
		dest[13] = (a00*b09 - a01*b07 + a02*b06)*invDet;
		dest[14] = (-a30*b03 + a31*b01 - a32*b00)*invDet;
		dest[15] = (a20*b03 - a21*b01 + a22*b00)*invDet;

		return dest;
	}

}
