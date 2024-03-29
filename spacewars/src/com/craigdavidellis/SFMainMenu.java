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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class SFMainMenu extends Activity {
    /** Called when the activity is first created. */
	final SFEngine engine = new SFEngine();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SFEngine.context = getApplicationContext();
       
        
        /** Fire up background music */
       SFEngine.musicThread = new Thread(){
        	public void run(){
        		Intent bgmusic = new Intent(getApplicationContext(), SFMusic.class);
        		startService(bgmusic);
  
        	}
        };
        SFEngine.musicThread.start();
        
        /** Creating menu button options in memory & Background transparency */
        ImageButton start = (ImageButton)findViewById(R.id.btnStart);
        ImageButton scores = (ImageButton)findViewById(R.id.btnScores);
        ImageButton exit = (ImageButton)findViewById(R.id.btnExit);
        
        start.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
        start.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
        
        scores.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
        scores.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
        
        exit.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA); 
        exit.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
        
        start.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				/** Start the Game!!!! :)  */
				Intent game = new Intent(getApplicationContext(),SFGame.class);
				SFMainMenu.this.startActivity(game);

			}
        	
        });
        
        scores.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				boolean clean = false;
				clean = engine.onExit(v);	
				if (clean)
				{
					int pid= android.os.Process.myPid();
					android.os.Process.killProcess(pid);
				}
			}
        	});
        
        exit.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				boolean clean = false;
				clean = engine.onExit(v);	
				if (clean)
				{
					int pid= android.os.Process.myPid();
					android.os.Process.killProcess(pid);
				}
			}
        	});
    }
}