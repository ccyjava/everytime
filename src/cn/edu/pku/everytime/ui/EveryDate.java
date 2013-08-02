package cn.edu.pku.everytime.ui;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.model.ActionDealer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class EveryDate extends Fragment {

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
		View v = inflater.inflate(R.layout.every_date, container, false);
		ImageView iv = (ImageView) v.findViewById(R.id.every_date_calendar);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (EveryDate.this.getAd() != null) {
					ad.dealButton1();
				}

			}
		});
		return v;

	}
}
