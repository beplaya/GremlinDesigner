package com.aj.gremlindesigner.pickers.base;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Swiper extends SimpleOnGestureListener implements OnTouchListener {

	private static final int SWIPE_THRESHOLD = 100;
	private static final int SWIPE_VELOCITY_THRESHOLD = 100;
	private ISwipeListener swipeListener;
	private GestureDetector gestureDetector;

	public interface ISwipeListener {
		public void onSwipeRight();

		public void onSwipeLeft();

		public void onSwipeTop();

		public void onSwipeBottom();
	}

	public Swiper(ISwipeListener swipeListener, Context context) {
		this.swipeListener = swipeListener;
		this.gestureDetector = new GestureDetector(context, this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return true;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		boolean result = false;
		try {
			float diffY = e2.getY() - e1.getY();
			float diffX = e2.getX() - e1.getX();
			if (Math.abs(diffX) > Math.abs(diffY)) {
				if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
					if (diffX > 0) {
						swipeListener.onSwipeRight();
					} else {
						swipeListener.onSwipeLeft();
					}
				}
			} else {
				if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
					if (diffY > 0) {
						swipeListener.onSwipeBottom();
					} else {
						swipeListener.onSwipeTop();
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return result;
	}

}
