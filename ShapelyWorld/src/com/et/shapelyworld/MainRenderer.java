package com.et.shapelyworld;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.inject.Inject;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;

import com.et.util.mesh.data.MeshData;
import com.et.util.mesh.data.MeshObject;
import com.et.util.mesh.fileparser.annotations.ObjMeshFileParser;
import com.et.util.mesh.fileparser.MeshObjectParser;
import com.et.util.mesh.fileparser.obj.ResourceObjFile;
import com.et.util.shaders.Shader;
import com.et.util.shaders.annotation.SimpleShader;

/**
 * Takes care of calling the appropriate renderers to render content on screen.
 */
public class MainRenderer implements GLSurfaceView.Renderer {
  
  @Inject @SimpleShader private Shader shader;
  @Inject @ObjMeshFileParser private MeshObjectParser<ResourceObjFile> objParser;
  @Inject private Context context;
  private MeshObject meshObj;
  
  public void onSurfaceCreated(GL10 unused, EGLConfig config) {
    GLES20.glClearColor(0.5f, 0.0f, 0.0f, 1.0f);
    InputStream meshObjStream = context.getResources().openRawResource(R.raw.simpletri);
    meshObj = objParser.parse(new ResourceObjFile(meshObjStream));
    Log.i("mesh", "" + meshObj.getAllMeshes().size());
    for (MeshData data : meshObj.getAllMeshes()) {
      Log.i("mesh", data.toString());
    }

    if (!shader.isCompiled()) {
      shader.compile();
      if (shader.getError() != "") {
        Log.d("Shader", shader.getError());
      }
    }
  }

  public void onDrawFrame(GL10 unused) {
    GLES20.glUseProgram(shader.getProgramId());
    // Draw background color
    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    
    // Get all the data
    int vPosHandle = GLES20.glGetAttribLocation(shader.getProgramId(), "vPosition");
    Log.i("errors?!", "" + (vPosHandle == -1));
    FloatBuffer verticies = meshObj.getMesh("SimpleTri").getVerticesForAndroid();
    IntBuffer vIndices = meshObj.getMesh("SimpleTri").getVertIndicesForAndroid();
    
    Log.i("vert", verticies.toString());
    GLES20.glEnableVertexAttribArray(vPosHandle);
    Log.i("errors?!", GLU.gluErrorString(GLES20.glGetError()));
    GLES20.glVertexAttribPointer(vPosHandle, 4, GLES20.GL_FLOAT, false, 16, verticies);
    Log.i("errors?!", GLU.gluErrorString(GLES20.glGetError()));
    
    // Draw!
    GLES20.glDrawElements(GLES20.GL_TRIANGLES, 3, GLES20.GL_UNSIGNED_INT, vIndices);
    Log.i("errors?!", GLU.gluErrorString(GLES20.glGetError()));
    
    // Reset the buffers
    GLES20.glDisableVertexAttribArray(vPosHandle);
  }

  public void onSurfaceChanged(GL10 unused, int width, int height) {
    GLES20.glViewport(0, 0, width, height);
  }
}
