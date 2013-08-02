package cn.edu.pku.everytime.model;

import android.app.Activity;
import android.content.Context;

public abstract class ActionDealer {
	public Activity activity;

	public ActionDealer(Activity context) {
		super();
		this.activity = context;
	}

	public ActionDealer() {
		super();
	}

	public abstract void dealButton1();

	public abstract void dealButton1(Object obj);

	public abstract void dealButton2();

	public abstract void dealButton3();

	public abstract void dealButton4();
}
