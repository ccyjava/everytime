package cn.edu.pku.everytime.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * TODO: document your custom view class.
 */
public class EveryAnimationSimple extends View {
    private Bitmap bitmap = null;
    private Animation animation =null;
    
    public EveryAnimationSimple(Context cont){
    	super(cont);
    }
    protected void onDraw(Canvas canvas){
    	super.onDraw(canvas);
    	if(bitmap!=null){
        	Rect dst = new Rect(this.getLeft(),this.getTop(),this.getRight(),this.getBottom());
        	canvas.drawBitmap(bitmap, null, dst,null);
    	}
    	
    }
    //public interface
    public void setDrawable(int id){
    	bitmap = ((BitmapDrawable)getResources().getDrawable(id)).getBitmap();
    }
    public void setAnimation(int id){
    	animation = AnimationUtils.loadAnimation(this.getContext(), id);
    	animation.setZAdjustment(Animation.ZORDER_TOP);
    }
    public void startAnimation(){
    	this.startAnimation(animation);
    }
}