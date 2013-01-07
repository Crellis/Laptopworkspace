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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler; /* */
import android.view.WindowManager;

public class SpacewarsActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	SFEngine.display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        super.onCreate(savedInstanceState);
        /*display the splash screen image*/
        setContentView(R.layout.splashscreen);
        /*start up the splash screen and main menu in a time delayed thread*/
        SFEngine.context = this;
        new Handler().postDelayed(new Thread() { /*Start a new Game Thread*/
        		@Override
        		public void run() {
                   Intent mainMenu = new Intent(SpacewarsActivity.this, SFMainMenu.class); /*Intent method to start main menu */
                   SpacewarsActivity.this.startActivity(mainMenu);
                   SpacewarsActivity.this.finish(); /* Kill the Main Menu */
                   overridePendingTransition(R.layout.fadein, R.layout.fadeout);
        		}
        	}, SFEngine.GAME_THREAD_DELAY);
    }
}