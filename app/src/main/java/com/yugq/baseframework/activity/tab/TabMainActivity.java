package com.yugq.baseframework.activity.tab;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yugq.baseframework.R;
import com.yugq.baseframework.activity.tab.frgment.MainFragment;
import com.yugq.baseframework.activity.tab.frgment.MainFragment2;
import com.yugq.baseframework.activity.tab.frgment.MainFragment3;
import com.yugq.baseframework.common.BaseActivity;
import com.yugq.baseframework.view.TitleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @description tab主界面
 * @author yugq
 * @data 2016-1-26
 * @modified 修改者，修改日期，修改内容
 */
public class TabMainActivity extends BaseActivity implements View.OnClickListener{

	private Toolbar toolbar;
	private boolean isLight;
	private TextView toolbar_title;
	private TitleView titleView;
	private LinearLayout tab_bar;
	private TextView menu_0;
	private TextView menu_1;
	private TextView menu_2;
	private List<TextView> navMenus;
	private Map<Integer, Fragment> pagers;
	private ViewPager viewpager;
	private FragmentPagerAdapter mAdapter;
	@Override
	protected int initLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initTitle() {
		titleView.setTitle("这个是标题");
		titleView.setvisible(View.VISIBLE,View.VISIBLE,View.VISIBLE);
	}

	@Override
	protected void initView() {
		titleView = (TitleView) findViewById(R.id.title_bar);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		tab_bar = (LinearLayout) findViewById(R.id.tab_bar);
		menu_0 = (TextView) findViewById(R.id.menu_0);
		menu_1 = (TextView) findViewById(R.id.menu_1);
		menu_2 = (TextView) findViewById(R.id.menu_2);
		initMenus();
	}


	/**
	 * 加载底部导航MENU
	 */
	private void initMenus() {
		navMenus = new ArrayList<TextView>();
		navMenus.add(menu_0);
		navMenus.add(menu_1);
		navMenus.add(menu_2);

		menu_0.setSelected(true);
		menu_1.setSelected(false);
		menu_2.setSelected(false);

		initFragments();
	}

	private void initFragments() {
		pagers = new HashMap<Integer, Fragment>();
		pagers.put(0, new MainFragment());
		pagers.put(1, new MainFragment2());
		pagers.put(2, new MainFragment3());
		mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		viewpager.setAdapter(mAdapter);
		viewpager.setOnPageChangeListener(new MyPageChangeListener());
		viewpager.setOffscreenPageLimit(3);
	}

	@Override
	protected void initClick() {
		super.initClick();
		titleView.setOnClickListener(this);
		menu_0.setOnClickListener(this);
		menu_1.setOnClickListener(this);
		menu_2.setOnClickListener(this);
	}


	/**
	 * 设置底部导航项选中时背景
	 */
	public void setNavMenuChecked(int flag) {

		for (int i = 0; i < navMenus.size(); i++) {
			navMenus.get(i).setSelected(false);
		}
		switch (flag) {
			case 0:
				menu_0.setSelected(true);
				break;
			case 1:
				menu_1.setSelected(true);
				break;
			case 2:
				menu_2.setSelected(true);
				break;
			default:
				break;
		}
	}

	private void setTabFragment(int index) {
		setNavMenuChecked(index);
		// viewpager.setCurrentItem(index);
		viewpager.setCurrentItem(index, false);
		Intent intent = new Intent();
		intent.putExtra("initTabByPush", -1);
		setIntent(intent);
	}

	class MyPageChangeListener implements ViewPager.OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int position) {
			switch (position) {
				case 0:
					setStatusBarColor(Color.BLUE);
					setNavMenuChecked(0);
					break;
				case 1:
					setStatusBarColor(Color.BLUE);
					setNavMenuChecked(1);
					break;
				case 2:
					setStatusBarColor(Color.YELLOW);
					setNavMenuChecked(2);
					break;
				default:
					break;
			}
		}

	}

	class MyFragmentPagerAdapter extends FragmentPagerAdapter {

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return pagers.size();
		}

		@Override
		public Fragment getItem(int arg0) {
			return pagers.get(arg0);
		}

	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.menu_0:
				setTabFragment(0);
				break;
			case R.id.menu_1:
				setTabFragment(1);
				break;
			case R.id.menu_2:
				setTabFragment(2);
				break;

			default:
				break;
		}
	}
}
