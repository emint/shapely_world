package com.et.util.shaders;

/**
 * Interface for a class representing a compiled shader.
 */
public interface Shader {
  
  /**
   * Returns the program ID returned by compiling this shader.
   */
  int getProgramId();
  
  /**
   * Returns if shader compiled and linked properly.
   */
  boolean isCompiled();
  
  /**
   * Returns a reason for error if shader was not compiled or empty string.
   */
  String getError();
  
  /**
   * Returns the shader code that was loaded.
   */
  String getShaderCode();
}
