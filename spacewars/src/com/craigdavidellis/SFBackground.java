package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class SFBackground {

	   private FloatBuffer vertexBuffer;
	   private FloatBuffer textureBuffer;
	   private ByteBuffer indexBuffer;
	   
	   private int[] textures = new int[1];

	   private float vertices[] = {      /**lists a series of points, x,y,z points. Entire background area*/
	                   0.0f, 0.0f, 0.0f, 
	                   1.0f, 0.0f, 0.0f,  
	                   1.0f, 1.0f, 0.0f,  
	                   0.0f, 1.0f, 0.0f,
	                                 };
	   
	    private float texture[] = {      /**Plots corner screen points of the image/texture created*/
	                   0.0f, 0.0f,
	                   1.0f, 0f,
	                   1f, 1.0f,
	                   0f, 1f, 
	                                  };
	        
	    private byte indices[] = {      /**Definition of the square, in 2 triangles, clockwise*/
	                   0,1,2, 
	                   0,2,3, 
	                                  };

	   public SFBackground() { /**Creating ByteBuffer with the values of the vertex and texture arrays*/
	      ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4); /**Floats are 4 times the size of a Byte*/
	      byteBuf.order(ByteOrder.nativeOrder());
	      vertexBuffer = byteBuf.asFloatBuffer();
	      vertexBuffer.put(vertices);
	      vertexBuffer.position(0);

	      byteBuf = ByteBuffer.allocateDirect(texture.length * 4);   /**Floats are 4 times the size of a Byte*/
	      byteBuf.order(ByteOrder.nativeOrder());
	      textureBuffer = byteBuf.asFloatBuffer();
	      textureBuffer.put(texture);
	      textureBuffer.position(0);

	      indexBuffer = ByteBuffer.allocateDirect(indices.length);
	      indexBuffer.put(indices);
	      indexBuffer.position(0);
	   }

	    public void draw(GL10 gl) {
	      gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
	      
	      gl.glFrontFace(GL10.GL_CCW);
	      gl.glEnable(GL10.GL_CULL_FACE);
	      gl.glCullFace(GL10.GL_BACK);
	           
	      gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);/**enable the vertex and texture states and loads the vertices and texture buffers into OpenGL */
	      gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

	      gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	      gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
	      
	      gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);      
	      
	      gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	      gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	      gl.glDisable(GL10.GL_CULL_FACE);
	   }
	   
	   
	     public void loadTexture(GL10 gl,int texture, Context context) { /**Takes a pointer and loads the image into a bitmap stream. Stream is then closed*/
	      InputStream imagestream = context.getResources().openRawResource(texture);
	      Bitmap bitmap = null;
	      try {
	        
	    	  bitmap = BitmapFactory.decodeStream(imagestream);

	      }catch(Exception e){
	    	  
	      }finally {
	         //Always clear and close
	         try {
	        	 imagestream.close();
	        	 imagestream = null;
	         } catch (IOException e) {
	         }
	      }

	      gl.glGenTextures(1, textures, 0); /**Generates a texture pointer, structured like a dictionary*/
	      /**First parameter is the number of texture names that are needed to be generated*/
	      gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);  /**Binds texture into OpenGL*/
	      
	      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST); /**Mapping texture onto vertices, quickly to produce sharp pixels*/
	      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

	      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);/**OpenGL to continuously repeat the background textures */
	      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
	      
	      GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
	      
	      bitmap.recycle();
	   }
	}
