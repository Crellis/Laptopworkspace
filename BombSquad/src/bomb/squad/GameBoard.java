package bomb.squad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

public class GameBoard extends View{
	
	private int mBombX = -1;
	private int mBombY = -1;
	private Bitmap mBitmap = null;
	private Paint mPaint = null;
	private boolean isBombHidden = false;
	private int mBoundX = -1;
	private int mBoundY = -1;
	
	//play with these values to make the app more or less challenging
	public final int CLOSER = 50;
	public final int CLOSE = 100;
	
	MediaPlayer mpExplode;
	
	public GameBoard(Context context, AttributeSet aSet) { 
		super(context, aSet); 
		//load our bitmap
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
		//create a paint brush
		mPaint = new Paint();
		mPaint.setColor(Color.DKGRAY);
		
	}
	
	@Override
    public void onDraw(Canvas canvas) {
		//initialize
		if ((mBombX < 1) || (mBombY < 1)) {
    		mBombX = (int) (getWidth() / 2) - mBitmap.getWidth() / 2;
    		mBombY = (int) (getHeight() / 2) - mBitmap.getHeight() / 2;
    		mBoundX = (int)getWidth() - mBitmap.getWidth();
    		mBoundY = (int)getHeight() - mBitmap.getHeight();
    	}
		//draw background
    	canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
		//draw the Bomb
    	if (!isBombHidden) {
    		canvas.drawBitmap(mBitmap, mBombX, mBombY, null);
    	}
    }
	
	public void hideTheBomb(){
		//randomize Bomb location 
		mBombX = (int) Math.ceil(Math.random() * mBoundX);
		mBombY = (int) Math.ceil(Math.random() * mBoundY);
		isBombHidden = true;
		//force redraw
		invalidate();	
	}
	
	public void giveUp(){
		isBombHidden = false;
		//force redraw
	    mpExplode.start();
		invalidate();
	}	
	
	public Indicators takeAGuess(float x, float y) {
		
		//this is our "warm" area
		Rect prettyClose = new Rect(mBombX - CLOSE, mBombY - CLOSE, mBombX+mBitmap.getWidth() + CLOSE, mBombY+mBitmap.getHeight() + CLOSE);
		//normalize
		if (prettyClose.left < 0) prettyClose.left = 0;
		if (prettyClose.top < 0) prettyClose.top = 0;
		if (prettyClose.right > mBoundX) prettyClose.right = mBoundX;
		if (prettyClose.bottom > mBoundY) prettyClose.bottom = mBoundY;
		
		//this is our "hot" area
		Rect reallyClose = new Rect(mBombX - CLOSER, mBombY - CLOSER, mBombX+mBitmap.getWidth() + CLOSER, mBombY+mBitmap.getHeight() + CLOSER);
		//normalize
		if (reallyClose.left < 0) reallyClose.left = 0;
		if (reallyClose.top < 0) reallyClose.top = 0;
		if (reallyClose.right > mBoundX) reallyClose.right = mBoundX;
		if (reallyClose.bottom > mBoundY) reallyClose.bottom = mBoundY;
		
		//this is the area that contains our Bomb
		Rect bullsEye = new Rect(mBombX, mBombY, mBombX+mBitmap.getWidth(), mBombY+mBitmap.getHeight());
		
		//check to see where on the board the user pressed
		if (bullsEye.contains((int) x, (int)y)) {
			//found it
			isBombHidden = false;
			
			invalidate();
			return Indicators.BULLSEYE;
		} else if (reallyClose.contains((int) x, (int)y)) {
			//hot
			return Indicators.HOT;
		} else if (prettyClose.contains((int)x, (int)y)) {
			//warm
			return Indicators.WARM;
		} else {
			//not even close
			return Indicators.COLD;
		}
	}
}
