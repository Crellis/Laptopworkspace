package gameApp.activity;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class Panel extends SurfaceView implements SurfaceHolder.Callback {
	 
	private ArrayList<Element> mElements = new ArrayList<Element>();
	private ViewThread mThread;
	private int mElementNumber = 0;
	
	private Paint mPaint = new Paint();
	
	public static float mWidth;
	public static float mHeight;
	
	public Panel(Context context) {
		super(context);
		getHolder().addCallback(this);
		mThread = new ViewThread(this);
		mPaint.setColor(Color.WHITE);
	}
	
	public void doDraw(long elapsed, Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		synchronized (mElements) {
			for (Element element : mElements) {
			element.doDraw(canvas);
			}
		}
		canvas.drawText("FPS: " + Math.round(1000f / elapsed) + " Elements: " + mElementNumber, 10, 10, mPaint);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
		mWidth = width;
		mHeight = height;
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder){
		if (!mThread.isAlive()){
			mThread = new ViewThread(this);
			mThread.setRunning(true);
			mThread.start();
		}
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder){
		if (mThread.isAlive()) {
			mThread.setRunning(false);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (mElements) {
		mElements.add(new Element(getResources(), (int) event.getX(), (int) event.getY()));
		mElementNumber = mElements.size();
		}
		return super.onTouchEvent(event);
	}
	
	public void animate(long elapsedTime) {
        synchronized (mElements) {
            for (Element element : mElements) {
                element.animate(elapsedTime);
            }
        }
    }
		
}