package bomb.squad;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;


public class Main extends Activity implements OnTouchListener, OnClickListener{
	
	private GameBoard mGameBoard = null;
	private boolean isBombHidden = false;
	MediaPlayer mpStartup;
	MediaPlayer mpExplode;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mGameBoard = (GameBoard) findViewById(R.id.the_canvas);
        mGameBoard.setOnTouchListener(this);
        Button b = (Button) findViewById(R.id.the_button);
        b.setOnClickListener(this);
        MediaPlayer mpStartup = MediaPlayer.create(this, R.raw.battle);
        mpStartup.start();
        
    }

    @Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.getId() == R.id.the_canvas) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				if (isBombHidden) {
					TextView tv = (TextView)findViewById (R.id.the_label);
					switch (mGameBoard.takeAGuess(event.getX(), event.getY())) {
					case BULLSEYE:
						Button b = (Button) findViewById(R.id.the_button);
						isBombHidden = false;
						b.setText("Hide the Flag!");
						tv.setText("You found it!");
						tv.setTextColor(Color.GREEN);
						break;
					case HOT:
						tv.setText("You're hot!");
						tv.setTextColor(Color.RED);
						break;
					case WARM:
						tv.setText("Getting warm...");
						tv.setTextColor(Color.YELLOW);
						break;
					case COLD:
						tv.setText("You're cold.");
						tv.setTextColor(Color.BLUE);
						break;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.the_button) {
			TextView tv = (TextView)findViewById (R.id.the_label);
			tv.setText("");
			Button b = (Button) findViewById(R.id.the_button);
			isBombHidden = !isBombHidden;
			if (isBombHidden) {
				b.setText("Give Up!");
				mGameBoard.hideTheBomb();
			} else {
				b.setText("Hide the Bomb!");
				mGameBoard.giveUp();
			}
		}
	}
}