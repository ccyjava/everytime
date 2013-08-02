package cn.edu.pku.everytime.ui;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.model.ActionDealer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class EveryNavigator extends Fragment {

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
		View v = inflater.inflate(R.layout.everybar, container);
		RadioButton rb_task = (RadioButton) v.findViewById(R.id.btn_task);
		RadioButton rb_memo = (RadioButton) v.findViewById(R.id.btn_memo);
		RadioButton rb_date = (RadioButton) v.findViewById(R.id.btn_date);
		RadioButton rb_statistic = (RadioButton) v
				.findViewById(R.id.btn_statistic);
		rb_task.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton1();
				}
			}
		});
		rb_memo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton2();
				}
			}
		});
		rb_date.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton3();
				}
			}
		});
		rb_statistic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (ad != null) {
					ad.dealButton4();
				}
			}
		});

		return v;
	}

	public void changeToFirst() {
		RadioButton rb = (RadioButton) this.getView().findViewById(
				R.id.btn_task);
		rb.setChecked(true);
	}
}
