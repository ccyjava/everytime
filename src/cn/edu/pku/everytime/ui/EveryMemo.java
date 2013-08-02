package cn.edu.pku.everytime.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import cn.edu.pku.everytime.R;
import cn.edu.pku.everytime.model.Memo;
import cn.edu.pku.everytime.model.Task;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EveryMemo extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.every_memo, container, false);
		ListView listview = (ListView) v.findViewById(R.id.every_memo_list);
		// Button button = (Button) v.findViewById(R.id.every_memo_btn_new);
		// button.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Dialog dialog = new Dialog_add_memo(getActivity(),
		// R.style.MyDialog);
		// dialog.show();
		// dialog.getWindow().setLayout(411, 426);
		//
		// }
		// });

		((Button) v.findViewById(R.id.every_memo_btn_new))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Dialog dialog = new Dialog_add_memo(getActivity(),
								R.style.MyDialog);
						dialog.show();
						dialog.getWindow().setLayout(411, 426);

					}
				});

		final Typeface typeface = Typeface.createFromAsset(getActivity()
				.getAssets(), "font/fzxqzw.ttf");
		final List<Memo> memolist = new LinkedList<Memo>();
		fullFillList(memolist);// just demo
		final Comparator<Memo> comp = new Comparator<Memo>() {

			@Override
			public int compare(Memo lhs, Memo rhs) {
				return lhs.getDate().compareTo(rhs.getDate());
			}
		};
		Collections.sort(memolist, comp);
		final BaseAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				return memolist.size();
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
				LinearLayout item = (LinearLayout) getLayoutInflater(null)
						.inflate(R.layout.memo_item_view, null);
				// LinearLayout item = (LinearLayout)
				// findViewById(R.layout.task_item_view);
				TextView memocontent = (TextView) (item
						.findViewById(R.id.memo_item_content));
				TextView memodate = (TextView) (item
						.findViewById(R.id.memo_item_date));
				memocontent.setTypeface(typeface);
				memocontent.setText(memolist.get(position).getContent());
				memodate.setTypeface(typeface);
				memodate.setText(memolist.get(position).getDate());
				return item;
			}

		};
		listview.setAdapter(adapter);
		return v;
	}

	static void fullFillList(List<Memo> list) {
		list.add(new Memo("开会", "7月20\n2013"));
		list.add(new Memo("上课", "7月24\n2013"));
		list.add(new Memo("上班", "7月27\n2013"));
		list.add(new Memo("打电话", "7月28\n2013"));
	}
}
