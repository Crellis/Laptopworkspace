package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */
import android.content.Context;
import android.opengl.GLSurfaceView;

public class SFGameView extends GLSurfaceView {
	private SFGameRenderer renderer;
	
	public SFGameView(Context context) {
		super(context);
		
		renderer = new SFGameRenderer();
		
		this.setRenderer(renderer);
		
	}
}