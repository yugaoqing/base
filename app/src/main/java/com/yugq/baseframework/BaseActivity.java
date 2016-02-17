package com.yugq.baseframework;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initLayoutId());
		initView();
		initTitle();
		initClick();
	}
	
	/**
	 * 布局文件ID
	 * 
	 * @return
	 */
	abstract protected int initLayoutId();

	abstract protected void initTitle();

	abstract protected void initView();

	/**
	 * 初始化数据/刷新
	 */
	protected void initData() {

	}

	/**
	 * 加载更多
	 */
	protected void loadMore() {

	}
	/**
	 * 点击事件
	 */
	protected void initClick() {

	}

	@TargetApi(21)
	protected void setStatusBarColor(int statusBarColor) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = this.getWindow();
			if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
				window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			} else {
				window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			}
			window.setStatusBarColor(statusBarColor);
		}
	}

}
