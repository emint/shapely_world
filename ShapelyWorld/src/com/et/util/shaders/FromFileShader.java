package com.et.util.shaders;

import java.io.IOException;

import javax.inject.Inject;

import com.et.util.assetreader.AssetReader;

/**
 * This class reads in a file from the android assets and then compiles it as a shader.
 */
public class FromFileShader implements Shader {

  private String error;
  private boolean isCompiled = false;
  private String shaderCode;
  
  @Inject
  public FromFileShader(AssetReader assetReader, String shaderLocation) {
    try {
      shaderCode = new String(assetReader.readFile(shaderLocation));
    } catch (IOException e) {
      e.printStackTrace();
      error = e.getMessage();
    }
  }
  
  @Override
  public int getProgramId() {
    return 0;
  }

  @Override
  public boolean isCompiled() {
    return isCompiled;
  }

  @Override
  public String getError() {
    return error;
  }

  @Override
  public String getShaderCode() {
    return shaderCode;
  }

}
