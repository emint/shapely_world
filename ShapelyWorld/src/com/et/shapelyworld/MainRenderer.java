package com.et.shapelyworld;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

/**
 * Takes care of calling the appropriate renderers to render content on screen.
 */
public class MainRenderer implements GLSurfaceView.Renderer {

  public void onSurfaceCreated(GL10 unused, EGLConfig config) {
    GLES20.glClearColor(0.5f, 0.0f, 0.0f, 1.0f);
  }

  public void onDrawFrame(GL10 unused) {
    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
  }

  public void onSurfaceChanged(GL10 unused, int width, int height) {
    GLES20.glViewport(0, 0, width, height);
  }
}
