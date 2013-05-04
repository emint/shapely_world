package com.et.shapelyworld;

import roboguice.RoboGuice;
import android.app.Application;

/**
 * Creates the proper RoboGuice injector.
 */
public class MainApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();

    RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
        RoboGuice.newDefaultRoboModule(this), new MainModule());
  }
}
