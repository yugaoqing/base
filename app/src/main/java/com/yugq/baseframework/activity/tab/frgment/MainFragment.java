package com.yugq.baseframework.activity.tab.frgment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yugq.baseframework.BaseFragment;
import com.yugq.baseframework.R;

public class MainFragment extends BaseFragment {

	protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_news_layout, container, false);
		return view;
	}
}
