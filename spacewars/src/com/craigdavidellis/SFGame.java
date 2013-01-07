package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SFGame extends Activity {
	final SFEngine gameEngine = new SFEngine();
	private SFGameView gameView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new SFGameView(this);
        setContentView(gameView);
        
        
    }
    @Override
    protected void onResume() {
       super.onResume();
       gameView.onResume();
    }

    @Override
    protected void onPause() {
       super.onPause();
       gameView.onPause();
    }

   	@Override
   	public boolean onTouchEvent(MotionEvent event) {
   		//
   		float x = event.getX();
        float y = event.getY();
        int height = SFEngine.display.getHeight() / 4;
        int playableArea = SFEngine.display.getHeight() - height;
        if (y > playableArea){
        	switch (event.getAction()){
        	case MotionEvent.ACTION_DOWN:
        		if(x < SFEngine.display.getWidth() / 2){
        			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_LEFT_1;
        		}else{
        			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_RIGHT_1;
        		}
        		break;
        	case MotionEvent.ACTION_UP:
        		SFEngine.playerFlightAction = SFEngine.PLAYER_RELEASE;
        		break;
        	}
        }
		return false;
    }	
}
