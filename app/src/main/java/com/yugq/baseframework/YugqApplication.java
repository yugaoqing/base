package com.yugq.baseframework;

import android.app.Application;

public class YugqApplication extends Application {
	public static String user_id;// 判断是否登陆

	@Override
	public void onCreate() {
		super.onCreate();
	}
}
