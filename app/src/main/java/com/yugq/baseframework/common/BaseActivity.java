package com.yugq.baseframework.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.yugq.baseframework.utils.PreferencesHelper;

public abstract class BaseActivity extends FragmentActivity {

	protected Context mContext;
	protected PreferencesHelper mHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initLayoutId());
		mContext = this;
		mHelper = new PreferencesHelper(mContext);
		setContentView(initLayoutId());
		initView();
		initTitle();
		initClick();
	}
	
	/**
	 * 布局文件ID
	 * 
	 * @return layoutID
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

	/**
	 * 设置浸透式效果（4.4版本以上适用）
	 */
	public void setStatusBarColor(int color) {
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			setTranslucentStatus(true);// 4.4以上效果，只能在这里设置
//			SystemBarTintManager tintManager = new SystemBarTintManager(this);
//			tintManager.setStatusBarTintEnabled(true);
//			tintManager.setStatusBarTintResource(color);
//		}
	}

//	@TargetApi(19)
//	private void setTranslucentStatus(boolean on) {
//		Window win = getWindow();
//		WindowManager.LayoutParams winParams = win.getAttributes();
//		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//		if (on) {
//			winParams.flags |= bits;
//		} else {
//			winParams.flags &= ~bits;
//		}
//		win.setAttributes(winParams);
//	}

}
