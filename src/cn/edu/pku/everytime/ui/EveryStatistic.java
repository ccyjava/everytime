package cn.edu.pku.everytime.ui;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.action.ActionFactory;
import cn.edu.pku.everytime.model.ActionDealer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;

public class EveryStatistic extends Fragment {

	ActionDealer ad;

	public ActionDealer getAd() {
		return ad;
	}

	public void setAd(ActionDealer ad) {
		this.ad = ad;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.every_statistic, container, false);

		this.setAd(ActionFactory.genStatisticActionDealer(getActivity(),
				(ImageView) (v.findViewById(R.id.statistic_chart_view))));
		RadioButton rb_score = (RadioButton) v
				.findViewById(R.id.statistic_btn_score);
		RadioButton rb_trend = (RadioButton) v
				.findViewById(R.id.statistic_btn_trend);
		RadioButton rb_topic = (RadioButton) v
				.findViewById(R.id.statistic_btn_topic);
		RadioButton rb_outline = (RadioButton) v
				.findViewById(R.id.statistic_btn_outline);
		rb_score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton1();
				}
			}
		});
		rb_trend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton2();
				}
			}
		});
		rb_topic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton3();
				}
			}
		});
		rb_outline.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton4();
				}
			}
		});

		return v;

	}
}
