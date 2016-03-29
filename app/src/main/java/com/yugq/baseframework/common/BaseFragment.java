package com.yugq.baseframework.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * @description fragment基础类
 * @author yugq
 * @data 2016-3-29
 * @modified 修改者，修改日期，修改内容
 */
public abstract class BaseFragment extends Fragment {
	protected Activity mContext;
	protected View baseView;
	protected boolean isVisible = false;
	// 标志位，标志已经初始化完成（防止onCreateView未调用之前就调用该方法导致空指针）
	protected boolean isPrepared = false;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getActivity();
		if (baseView == null) {
			baseView = LayoutInflater.from(mContext).inflate(setBaseView(), null);
			initView();
			isPrepared = true;
		} else if (baseView.getParent() != null) {
			((ViewGroup) baseView.getParent()).removeAllViews();
		}
		return baseView;
	}



	/**
	 * 设置baseview
	 *
	 * @return fragment baseview
	 */
	protected abstract int setBaseView();

	/**
	 * (non-Javadoc) UI初始化
	 */
	protected abstract void initView();

	/**
	 * 数据加载
	 */
	protected abstract void initData();

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (getUserVisibleHint()) {
			isVisible = true;
			onVisible();
		} else {
			isVisible = false;
			onInvisible();
		}
	}

	protected void onVisible() {
		if (!isPrepared || !isVisible) {
			return;
		}
		initData();
	}

	protected void onInvisible() {
	}

	@Override
	public void onResume() {
		super.onResume();
		if (getUserVisibleHint()) {
			initData();
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mContext = null;
	}

}
