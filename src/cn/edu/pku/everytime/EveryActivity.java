package cn.edu.pku.everytime;

import java.util.LinkedList;

import java.util.List;

import cn.edu.pku.everytime.action.ActionFactory;
import cn.edu.pku.everytime.animation.AnimViewPro;
import cn.edu.pku.everytime.animation.EveryAnimationSimple;
import cn.edu.pku.everytime.animation.ScrollPicView;
import cn.edu.pku.everytime.model.ActionDealer;
import cn.edu.pku.everytime.model.Task;
import cn.edu.pku.everytime.ui.EveryDate;
import cn.edu.pku.everytime.ui.EveryMemo;
import cn.edu.pku.everytime.ui.EveryNavigator;
import cn.edu.pku.everytime.ui.EveryStatistic;
import cn.edu.pku.everytime.ui.EveryTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class EveryActivity extends FragmentActivity {

	Fragment everytask = null;
	Fragment everystatistic = null;
	Fragment everydate = null;
	Fragment everymemo = null;
	Fragment prefragment = null;
	EveryNavigator everynavigator = null;

	public ScrollPicView spv1 = null;
	public ScrollPicView spv2 = null;

	public Handler hd = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				// EveryActivity.this.setContentView(R.layout.activity_main);
				AnimViewPro animviewpro = new AnimViewPro(EveryActivity.this);
				animviewpro.setDrawable(R.drawable.animation_cat);
				animviewpro.setAnimation(R.anim.alpha_scale_switch);
				// add animationview
				ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT);
				EveryActivity.this.addContentView(animviewpro, lp);
				animviewpro.startAnimation();
				break;

			case 1:
				// EveryActivity.this.setContentView(R.layout.activity_main);
				break;
			}
		}// end switch
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// delete title
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		spv1 = (ScrollPicView) this.findViewById(R.id.scrollviewfirst);
		spv2 = (ScrollPicView) this.findViewById(R.id.scrollviewSecond);
		spv1.setVisibility(View.INVISIBLE);
		spv2.setVisibility(View.INVISIBLE);

		everytask = new EveryTask();
		everystatistic = new EveryStatistic();
		everymemo = new EveryMemo();
		everydate = new EveryDate();
		prefragment = everytask;
		FragmentManager fg = getSupportFragmentManager();
		everynavigator = (EveryNavigator) fg
				.findFragmentById(R.id.every_navigator);
		everynavigator.setAd(genAd());
		((EveryDate) everydate).setAd(genAd());
		FragmentTransaction transaction = fg.beginTransaction();
		transaction.add(R.id.every_container, everytask);
		// transaction.add(R.id.every_container, new EveryStatistic());
		// transaction.replace(R.id.every_container, new EveryStatistic());
		transaction.commit();

		// listview.setVisibility(View.GONE);
		hd.sendEmptyMessage(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.every, menu);
		return true;
	}

	public ActionDealer genAd() {
		ActionDealer ad = new ActionDealer(this) {

			@Override
			public void dealButton4() {
				View view = this.activity.findViewById(R.id.activity_everymain);
				view.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.b4_1));

				changeFragment(everystatistic);
				// FragmentManager fg = getSupportFragmentManager();
				// FragmentTransaction transaction = fg.beginTransaction();
				// // transaction.add(R.id.every_container, new EveryTask());
				// // transaction.add(R.id.every_container, new
				// EveryStatistic());
				// transaction.replace(R.id.every_container, everystatistic);
				// transaction.commit();

			}

			@Override
			public void dealButton3() {
				View view = this.activity.findViewById(R.id.activity_everymain);
				view.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.b3));
				changeFragment(everydate);

				// FragmentManager fg = getSupportFragmentManager();
				// FragmentTransaction transaction = fg.beginTransaction();
				// // transaction.add(R.id.every_container, new EveryTask());
				// // transaction.add(R.id.every_container, new
				// EveryStatistic());
				// transaction.replace(R.id.every_container, everydate);
				// transaction.commit();

			}

			@Override
			public void dealButton2() {

				// EveryAnimationSimple eas = new EveryAnimationSimple(
				// EveryActivity.this);
				// eas.setDrawable(R.drawable.animation_cat);
				// eas.setAnimation(R.anim.alpha_scale_switch);
				// // add animationview
				// ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
				// ViewGroup.LayoutParams.MATCH_PARENT,
				// ViewGroup.LayoutParams.MATCH_PARENT);
				// EveryActivity.this.addContentView(eas, lp);
				// eas.startAnimation();

				View view = this.activity.findViewById(R.id.activity_everymain);
				view.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.b2));

				// //
				// ///////////////////////////////////////////////////////////
				// // getview
				// // View preview = everytask.getView();
				// // load animation
				// Animation anim = AnimationUtils.loadAnimation(
				// EveryActivity.this, R.anim.alpha_switch);
				// anim.setZAdjustment(Animation.ZORDER_TOP);
				// // addview
				// // ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(
				// //
				// ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
				// prefragment.getView().setBackgroundResource(R.drawable.b1);
				// // EveryActivity.this.addContentView(preview,lp);
				// prefragment.getView().startAnimation(anim);
				//
				// FragmentManager fg = getSupportFragmentManager();
				// FragmentTransaction transaction = fg.beginTransaction();
				// // transaction.add(R.id.every_container, new EveryTask());
				// // transaction.add(R.id.every_container, new
				// EveryStatistic());
				// transaction.replace(R.id.every_container, everymemo);
				// prefragment = everymemo;
				// transaction.commit();

				changeFragment(everymemo);

			}

			@Override
			public void dealButton1() {
				View view = this.activity.findViewById(R.id.activity_everymain);
				view.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.b1));
				everynavigator.changeToFirst();
				changeFragment(everytask);
				// FragmentManager fg = getSupportFragmentManager();
				// FragmentTransaction transaction = fg.beginTransaction();
				// // transaction.add(R.id.every_container, new EveryTask());
				// // transaction.add(R.id.every_container, new
				// EveryStatistic());
				// transaction.replace(R.id.every_container, everytask);
				// transaction.commit();
			}

			@Override
			public void dealButton1(Object obj) {
				// TODO Auto-generated method stub

			}
		};
		return ad;
	}

	public void changeFragment(Fragment fragment) {
		// ///////////////////////////////////////////////////////////
		// getview
		// View preview = everytask.getView();
		// load animation
		Animation anim = AnimationUtils.loadAnimation(EveryActivity.this,
				R.anim.alpha_switch);
		anim.setZAdjustment(Animation.ZORDER_TOP);
		// addview
		// ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(
		// ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
		prefragment.getView().setBackgroundResource(R.drawable.b1);
		// EveryActivity.this.addContentView(preview,lp);
		prefragment.getView().startAnimation(anim);

		FragmentManager fg = getSupportFragmentManager();
		FragmentTransaction transaction = fg.beginTransaction();
		// transaction.add(R.id.every_container, new EveryTask());
		// transaction.add(R.id.every_container, new EveryStatistic());
		transaction.replace(R.id.every_container, fragment);
		prefragment = fragment;
		transaction.commit();
	}
}

// addtaskbutton.setOnClickListener(new OnClickListener() {
//
// @Override
// public void onClick(View v) {
// final TableLayout newtask = (TableLayout) getLayoutInflater()
// .inflate(R.layout.new_task, null);
// final Task tmptask = new Task();
// tmptask.setComplate(0);
// builder.setView(newtask);
// final AlertDialog dialog = builder.create();
// dialog.setCanceledOnTouchOutside(false);

// Button addtaskbutton = (Button) newtask
// .findViewById(R.id.add_task);
// SeekBar importance = (SeekBar) newtask
// .findViewById(R.id.choose_importance);
// importance
// .setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
//
// @Override
// public void onProgressChanged(SeekBar seekBar,
// int progress, boolean fromUser) {
// tmptask.setImportance(progress / 100.0);
// }
//
// @Override
// public void onStartTrackingTouch(SeekBar seekBar) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void onStopTrackingTouch(SeekBar seekBar) {
// // TODO Auto-generated method stub
//
// }
// });
// addtaskbutton.setOnClickListener(new OnClickListener() {
//
// @Override
// public void onClick(View v) {
// EditText newtasktitle = (EditText) newtask
// .findViewById(R.id.new_task_title);
// tmptask.setTitle(newtasktitle.getText().toString());
// tasklist.add(tmptask);
// Collections.sort(tasklist, comp);
// adapter.notifyDataSetChanged();
// dialog.dismiss();
// }
// });
//
// dialog.show();
//
// }
// });
