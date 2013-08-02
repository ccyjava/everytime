package cn.edu.pku.everytime.test;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.ui.Dialog_in_new_task;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Task_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		Button button_dialog = (Button) findViewById(R.id.button_dialog);
		Button.OnClickListener listener = new Button.OnClickListener() {// 创建监听对
			public void onClick(View v) {
				// 初始化一个自定义的Dialog
				Dialog dialog = new Dialog_in_new_task(Task_activity.this,
						R.style.MyDialog);
				dialog.show();
				dialog.getWindow().setLayout(411, 426);
				// ImageButton dialog_cancle = (ImageButton) dialog
				// .findViewById(R.id.dialog_cancle);
				//
				// dialog_cancle.setOnClickListener(new Button.OnClickListener()
				// {
				//
				// @Override
				// public void onClick(View v) {
				// // TODO Auto-generated method stub
				// Toast.makeText(Task_activity.this, "取消",
				// Toast.LENGTH_SHORT).show();
				//
				// }
				// });

			}

		};
		button_dialog.setOnClickListener(listener);// 设置监听

	}

}
