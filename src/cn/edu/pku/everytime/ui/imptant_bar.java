package cn.edu.pku.everytime.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class imptant_bar extends View {

	public static final String TAG = imptant_bar.class.getSimpleName();
	private Context mContext = null;
	private Path mPath = null;
	private Paint mPaint = null;
	private Paint mBitmapPaint = null;// 画布的画笔
	private Canvas mCanvas = null;
	private Bitmap mBitmap = null;
	private int mWidth = 0;
	private int mHeight = 0;

	private int mX, mY;
	private final int SPACE = 4;
	private boolean mInit = false;

	public imptant_bar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		// InitView(context);
		mContext = context;
	}

	public imptant_bar(Context context, AttributeSet a) {
		super(context, a);
		// TODO Auto-generated constructor stub
		// InitView(context);
		mContext = context;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		Log.i(TAG, "onLayout ");
		InitView(mContext);
		super.onLayout(changed, left, top, right, bottom);
	}

	private void InitView(Context context) {

		mWidth = this.getWidth();
		mHeight = this.getHeight();
		Log.i(TAG, "mWidth=" + mWidth + " mHeight=" + mHeight);

		mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);

		mBitmapPaint = new Paint(Paint.DITHER_FLAG);
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(0xffFF9999);// 设置为红色
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);// 设置外边缘
		mPaint.setStrokeCap(Paint.Cap.BUTT);// 形状
		mPaint.setStrokeWidth(20);// 画笔宽度
		mInit = true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			touch_down(x, y);
			break;
		}
		case MotionEvent.ACTION_UP: {
			touch_up(x, y);
			break;
		}
		case MotionEvent.ACTION_MOVE: {
			touch_move(x, y);
			break;
		}
		}
		return true;
	}

	private void touch_down(int x, int y) {
		Log.i(TAG, "touch_down x=" + x + " y=" + y);
		mPath = new Path();
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
		this.postInvalidate();
	}

	private void touch_move(int x, int y) {
		// Log.i(TAG, "touch_down x=" + x + " y=" + y);
		int _x = Math.abs(x - mX);
		int _y = Math.abs(y - mY);
		if (_x > SPACE || _y > SPACE) {
			mPath.lineTo(x, y);
			mX = x;
			mY = y;
			this.postInvalidate();
		}
	}

	private void touch_up(int x, int y) {
		Log.i(TAG, "touch_up x=" + x + " y=" + y);
		mPath.lineTo(x, y);
		mCanvas.drawPath(mPath, mPaint);
		this.postInvalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		if (!mInit)
			return;
		canvas.drawColor(0xFFF8F8FF);
		canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);

		if (mPath != null) {
			canvas.drawPath(mPath, mPaint);
		}
		super.onDraw(canvas);
	}
}
