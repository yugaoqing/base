package com.yugq.baseframework.activity.tab;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yugq.baseframework.BaseActivity;
import com.yugq.baseframework.R;
import com.yugq.baseframework.activity.tab.frgment.MainFragment;

/**
 * 
 * @description tab主界面
 * @author yugq
 * @data 2016-1-26
 * @modified 修改者，修改日期，修改内容
 */
public class TabMainActivity extends BaseActivity {

	private Toolbar toolbar;
	private boolean isLight;
	private TextView toolbar_title;

	@Override
	protected int initLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initTitle() {

	}

	@Override
	protected void initView() {
	}


}
