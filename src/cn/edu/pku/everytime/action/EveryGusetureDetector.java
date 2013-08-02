package cn.edu.pku.everytime.action;

import android.app.Activity;
import android.gesture.GestureOverlayView;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;

public class EveryGusetureDetector implements OnGestureListener {
	Activity at = null;

	public EveryGusetureDetector(Activity at) {
		this.at = at;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		Toast.makeText(at, "Down", 2000);
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Toast.makeText(at, "Filing", 2000);
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Toast.makeText(at, "Longpress", 2000);

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Toast.makeText(at, "scroll", 2000);
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		Toast.makeText(at, "showpress", 2000);

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Toast.makeText(at, "singletapup", 2000);
		return false;
	}

}
