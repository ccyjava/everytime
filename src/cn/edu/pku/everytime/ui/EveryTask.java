package cn.edu.pku.everytime.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.action.EveryGusetureDetector;
import cn.edu.pku.everytime.model.ActionDealer;
import cn.edu.pku.everytime.model.Task;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EveryTask extends Fragment {
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
		View v = inflater.inflate(R.layout.every_task, container, false);
		ListView listview = (ListView) v.findViewById(R.id.every_task_list);
		TextView amout = (TextView) v.findViewById(R.id.every_task_amout);
		TextView undo = (TextView) v.findViewById(R.id.every_task_undo);
		Button new_task = (Button) v.findViewById(R.id.every_task_add);
		final List<Task> tasklist = new LinkedList<Task>();
		final Comparator<Task> comp = new Comparator<Task>() {

			@Override
			public int compare(Task lhs, Task rhs) {
				return lhs.getImportance() > rhs.getImportance() ? -1 : 1;
			}
		};
		final Typeface typeface = Typeface.createFromAsset(getActivity()
				.getAssets(), "font/fzxqzw.ttf");
		amout.setTypeface(typeface);
		undo.setTypeface(typeface);
		fullFillList(tasklist);// just demo

		Collections.sort(tasklist, comp);
		final BaseAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				return tasklist.size();
			}

			@Override
			public Object getItem(int position) {
				return position;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				RelativeLayout item = (RelativeLayout) getLayoutInflater(null)
						.inflate(R.layout.task_item_view, null);
				// LinearLayout item = (LinearLayout)
				// findViewById(R.layout.task_item_view);
				TextView tasktitle = (TextView) (item
						.findViewById(R.id.task_title));
				tasktitle.setTypeface(typeface);
				tasktitle.setText(tasklist.get(position).getTitle());
				TextView taskimportance = (TextView) (item
						.findViewById(R.id.task_importance));
				taskimportance.setTypeface(typeface);
				taskimportance.setText("重要度: "
						+ String.valueOf((int) (tasklist.get(position)
								.getImportance() * 100)) + "%");
				TextView taskcomplete = (TextView) (item
						.findViewById(R.id.task_complete));
				taskcomplete.setTypeface(typeface);
				taskcomplete.setText("完成度: "
						+ String.valueOf((int) (tasklist.get(position)
								.getComplate() * 100)) + "%");
				return item;
			}

		};
		listview.setAdapter(adapter);
		new_task.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Dialog_in_new_task dialog_new_task = new Dialog_in_new_task(
						getActivity(), R.style.MyDialog);
				dialog_new_task.setAd(new ActionDealer() {

					@Override
					public void dealButton4() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dealButton3() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dealButton2() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dealButton1() {

					}

					@Override
					public void dealButton1(Object obj) {
						Task tmptask = new Task("", "", 0.8, 0.4);
						tmptask.setTitle((String) obj);
						tasklist.add(tmptask);
						Collections.sort(tasklist, comp);
						adapter.notifyDataSetChanged();

					}
				});
				dialog_new_task.show();
				dialog_new_task.getWindow().setLayout(411, 426);

			}
		});
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Dialog dialog_imptant = new Dialog_in_important(getActivity(),
						R.style.MyDialog);
				dialog_imptant.show();
				dialog_imptant.getWindow().setLayout(411, 426);

			}
		});

		listview.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				EveryGusetureDetector egd = new EveryGusetureDetector(
						getActivity());
				GestureDetector detector = new GestureDetector(egd);
				detector.onTouchEvent(event);
				return false;
			}
		});
		new_task.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				EveryGusetureDetector egd = new EveryGusetureDetector(
						getActivity());
				GestureDetector detector = new GestureDetector(egd);
				detector.onTouchEvent(event);
				return false;
			}
		});

		return v;
	}

	static void fullFillList(List<Task> list) {
		list.add(new Task("看书", "", 0.80, 0.20));
		list.add(new Task("学英语", "", 0.90, 0.50));
		list.add(new Task("写程序", "", 0.75, 0.40));

	}
}
