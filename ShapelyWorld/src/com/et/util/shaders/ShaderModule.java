package com.et.util.shaders;

import com.et.util.assetreader.AssetReader;
import com.et.util.shaders.annotation.SimpleShader;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Binds the different shaders that we use.
 */
public class ShaderModule extends AbstractModule {

  @Override
  protected void configure() {}
  
  @Provides @SimpleShader
  Shader provideSimpleShader(AssetReader assetProvider) {
    return new FromFileShader(assetProvider, "shaders/simpleshader.txt");
  }
}
