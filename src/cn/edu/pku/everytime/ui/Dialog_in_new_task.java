package cn.edu.pku.everytime.ui;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.model.ActionDealer;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class Dialog_in_new_task extends Dialog {

	Context context;
	ActionDealer ad = null;

	public ActionDealer getAd() {
		return ad;
	}

	public void setAd(ActionDealer ad) {
		this.ad = ad;
	}

	public Dialog_in_new_task(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public Dialog_in_new_task(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.dialog_new_task);

		ImageButton ok = (ImageButton) this.findViewById(R.id.dialog_task_ok);
		ImageButton cancel = (ImageButton) this
				.findViewById(R.id.dialog_task_cancle);
		ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// EditText newtasktitle = (EditText) newtask
				// .findViewById(R.id.new_task_title);
				// tmptask.setTitle(newtasktitle.getText().toString());
				// tasklist.add(tmptask);
				// Collections.sort(tasklist, comp);
				// adapter.notifyDataSetChanged();
				// dialog.dismiss();
				EditText ed = (EditText) findViewById(R.id.dialog_new_task_text);

				if (ad != null)
					ad.dealButton1(ed.getText().toString());
				Dialog_in_new_task.this.dismiss();

			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (ad != null)
					ad.dealButton2();
				Dialog_in_new_task.this.dismiss();

			}
		});

	}
}
