package cn.edu.pku.everytime.action;

import cn.edu.pku.everytime.EveryActivity;
import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.animation.ScrollBean;
import cn.edu.pku.everytime.animation.ScrollPicView;
import cn.edu.pku.everytime.model.ActionDealer;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class ActionFactory {
	public static ActionDealer genStatisticActionDealer(final Activity at,
			final ImageView iv) {
		return new ActionDealer(at) {

			@Override
			public void dealButton4() {

				EveryActivity ea = (EveryActivity) at;
				ScrollBean animb = new ScrollBean(ea.spv1, ea.spv2,
						R.drawable.b4_3, R.drawable.b4_4);
				animb.startAnimation();
				iv.setImageDrawable(at.getResources().getDrawable(
						R.drawable.statistic_content_outline));
				at.findViewById(R.id.activity_everymain).setBackgroundDrawable(
						at.getResources().getDrawable(R.drawable.b4_4));
			}

			@Override
			public void dealButton3() {

				EveryActivity ea = (EveryActivity) at;
				ScrollBean animb = new ScrollBean(ea.spv1, ea.spv2,
						R.drawable.b4_2, R.drawable.b4_3);
				animb.startAnimation();
				iv.setImageDrawable(at.getResources().getDrawable(
						R.drawable.statistic_content_topic));
				at.findViewById(R.id.activity_everymain).setBackgroundDrawable(
						at.getResources().getDrawable(R.drawable.b4_3));

			}

			@Override
			public void dealButton2() {
				// ScrollPicView spv1 = new ScrollPicView(at);
				// ScrollPicView spv2 =new ScrollPicView(at);

				EveryActivity ea = (EveryActivity) at;
				ScrollBean animb = new ScrollBean(ea.spv1, ea.spv2,
						R.drawable.b4_1, R.drawable.b4_2);
				animb.startAnimation();

				iv.setImageDrawable(at.getResources().getDrawable(
						R.drawable.statistic_content_trend));
				at.findViewById(R.id.activity_everymain).setBackgroundDrawable(
						at.getResources().getDrawable(R.drawable.b4_2));

			}

			@Override
			public void dealButton1() {

				EveryActivity ea = (EveryActivity) at;
				ScrollBean animb = new ScrollBean(ea.spv1, ea.spv2,
						R.drawable.b4_4, R.drawable.b4_1);
				animb.startAnimation();

				iv.setImageDrawable(at.getResources().getDrawable(
						R.drawable.statistic_content_score));
				at.findViewById(R.id.activity_everymain).setBackgroundDrawable(
						at.getResources().getDrawable(R.drawable.b4_1));

			}

			@Override
			public void dealButton1(Object obj) {
				// TODO Auto-generated method stub

			}
		};
	}

}
