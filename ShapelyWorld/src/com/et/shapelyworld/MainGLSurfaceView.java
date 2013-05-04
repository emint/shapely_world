package com.et.shapelyworld;

import javax.inject.Singleton;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * The main GLSurfaceView of the game. Responsible for setting-up the parameters
 * and registering the proper renderer.
 */
public class MainGLSurfaceView extends GLSurfaceView {

  @Inject
  @Singleton
  public MainGLSurfaceView(Provider<Context> contextProvider,
      GLSurfaceView.Renderer renderer) {
    super(contextProvider.get());

    setEGLContextClientVersion(2);
    setRenderer(renderer);
    setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
  }

}
