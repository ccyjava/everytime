package cn.edu.pku.everytime.animation;

import android.view.View;
import cn.edu.pku.everytime.R;

public class ScrollBean {
	private ScrollPicView spv1;
	private ScrollPicView spv2;
	private int id1;
	private int id2;

	public ScrollBean(ScrollPicView spv1, ScrollPicView spv2, int id1, int id2) {
		this.spv1 = spv1;
		this.spv2 = spv2;
		this.id1 = id1;
		this.id2 = id2;
	}

	public void startAnimation() {
		spv1.setVisibility(View.VISIBLE);
		spv2.setVisibility(View.VISIBLE);

		spv1.setDrawable(id1);
		spv2.setDrawable(id2);

		spv1.setAnimation(1);
		spv2.setAnimation(2);

		spv1.startAnimation();
		spv2.startAnimation();
	}
}
