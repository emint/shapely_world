package com.et.util.assetreader;

import com.google.inject.AbstractModule;

/**
 * Module defining bindings for AssetReader.
 */
public class AssetReaderModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(AssetReader.class).to(AssetReaderImpl.class);
  }

}
