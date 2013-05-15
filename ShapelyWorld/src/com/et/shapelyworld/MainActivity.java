package com.et.shapelyworld;

import roboguice.activity.RoboActivity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.google.inject.Inject;
/**
 * The entry point for our application; sets up our game's main GLSurface.
 */
public class MainActivity extends RoboActivity {

  @Inject
  GLSurfaceView surfaceView;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(surfaceView);
  }
}
