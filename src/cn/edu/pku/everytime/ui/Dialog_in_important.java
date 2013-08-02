package cn.edu.pku.everytime.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import cn.edu.pku.everytime.R;

public class Dialog_in_important extends Dialog {
	Context context;

	public Dialog_in_important(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public Dialog_in_important(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.dialog_imptant);

		ImageButton ok = (ImageButton) this
				.findViewById(R.id.dialog_imptant_ok);
		ImageButton cancel = (ImageButton) this
				.findViewById(R.id.dialog_imptant_cancle);
		ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Dialog_in_important.this.dismiss();

			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Dialog_in_important.this.dismiss();

			}
		});

	}

}
