package com.et.shapelyworld;

import android.opengl.GLSurfaceView;

import com.google.inject.AbstractModule;

/**
 * Provides the bindings for the main wiring.
 */
public class MainModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(GLSurfaceView.class).to(MainGLSurfaceView.class);
    bind(GLSurfaceView.Renderer.class).to(MainRenderer.class);
  }

}
