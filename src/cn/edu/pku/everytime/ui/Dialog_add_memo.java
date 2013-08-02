package cn.edu.pku.everytime.ui;

import cn.edu.pku.everytime.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Dialog_add_memo extends Dialog {
	Context context;

	public Dialog_add_memo(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public Dialog_add_memo(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.dialog_new_memo);

		ImageButton ok = (ImageButton) this.findViewById(R.id.dialog_memo_ok);
		ImageButton cancel = (ImageButton) this
				.findViewById(R.id.dialog_memo_cancle);
		ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Dialog_add_memo.this.dismiss();

			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Dialog_add_memo.this.dismiss();

			}
		});

	}

}
