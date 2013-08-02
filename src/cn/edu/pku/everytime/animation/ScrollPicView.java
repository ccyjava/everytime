package cn.edu.pku.everytime.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

/**
 * TODO: document your custom view class.
 */
public class ScrollPicView extends View {
	private Bitmap bitmap1 = null;
	private Animation animation = null;

	public ScrollPicView(Context cont, AttributeSet attrs) {
		super(cont, attrs);
	}

	public ScrollPicView(Context cont) {
		super(cont);
		// setAnimation();
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (bitmap1 != null) {
			// Rect dst1 = new Rect(this.getLeft(),this.getTop(),
			// this.getRight(),this.getBottom());
			Rect dst1 = new Rect(0, 0, 480, 800 - 38);
			canvas.drawBitmap(bitmap1, null, dst1, null);
		}

	}

	// public interface
	public void clear(){
		bitmap1=null;
	}
	public void setDrawable(int id) {
		bitmap1 = ((BitmapDrawable) getResources().getDrawable(id)).getBitmap();
	}

	public void setAnimation(int type) {
		if (type == 1) {
			animation = new TranslateAnimation(0, 0, 0, 38 - 800);
		} else {
			animation = new TranslateAnimation(0, 0, 800 - 38, 0);
		}

		animation.setDuration(1500);
		animation.setRepeatCount(0);
		animation.setFillAfter(true);
		animation.setZAdjustment(0);
		animation.setInterpolator(AnimationUtils.loadInterpolator(
				this.getContext(), android.R.anim.linear_interpolator));
		animation.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				ScrollPicView.this.setVisibility(View.INVISIBLE);
				ScrollPicView.this.clear();
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void startAnimation() {
		this.startAnimation(animation);
	}
}