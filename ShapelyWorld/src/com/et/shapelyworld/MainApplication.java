package com.et.shapelyworld;

import roboguice.RoboGuice;
import android.app.Application;

import com.et.util.assetreader.AssetReaderModule;
import com.et.util.glesdriver.GLESDriverModule;
import com.et.util.mesh.fileparser.MeshFileParserModule;
import com.et.util.shaders.ShaderModule;

/**
 * Creates the proper RoboGuice injector.
 */
public class MainApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();

    RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, 
        RoboGuice.newDefaultRoboModule(this), 
        new AssetReaderModule(),
        new MainModule(),
        new MeshFileParserModule(),
        new GLESDriverModule(),
        new ShaderModule());
  }
}
