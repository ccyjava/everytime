package cn.edu.pku.everytime.animation;

import cn.edu.pku.everytime.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

/**
 * TODO: document your custom view class.
 */
public class AnimViewPro extends View {
    private Bitmap bitmap = null;
    private Animation animation =null;
    private EveryActivity cont=null;
    
    public AnimViewPro(EveryActivity cont){
    	super(cont);
    	this.cont=cont;
    }
    protected void onDraw(Canvas canvas){
    	super.onDraw(canvas);
    	if(bitmap!=null){
        	Rect dst = new Rect(this.getLeft(),this.getTop(),this.getRight(),this.getBottom());
        	canvas.drawBitmap(bitmap, null, dst,null);
    	}
    	
    }
    //public interface
    public void clear(){
    	this.bitmap=null;
    }
    public void setDrawable(int id){
    	bitmap = ((BitmapDrawable)getResources().getDrawable(id)).getBitmap();
    }
    public void setAnimation(int id){
    	animation = AnimationUtils.loadAnimation(this.getContext(),id);
    	//animation.setFillAfter(true);
    	animation.setAnimationListener(new AnimationListener(){
    		public void onAnimationEnd(Animation animation){
    			
    			AnimViewPro.this.setVisibility(View.INVISIBLE);
    			AnimViewPro.this.clear();
    			cont.hd.sendEmptyMessage(1);
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
    public void startAnimation(){
    	this.startAnimation(animation);
    }
}