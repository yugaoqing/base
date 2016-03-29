package com.yugq.baseframework.activity.splash;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yugq.baseframework.R;
import com.yugq.baseframework.activity.login.LoginActivity;
import com.yugq.baseframework.activity.tab.TabMainActivity;
import com.yugq.baseframework.utils.TextUtils;

/**
 * @description 启动页
 * @author yugq
 * @data 2016-1-26
 * @modified 修改者，修改日期，修改内容
 */
public class SplashActivity extends Activity {
	private Activity mContext;
	private ImageView img_loading;
	private TextView iv_ignore;
	private RelativeLayout rl_ignore;
	private int adv_time = 2;// 倒计时默认2秒
	private String click_url = "";// 跳转链接
	private String image_url = "";// 启动页图片链接
	private boolean timeOut = false;// 计时是否结束
	private boolean isTopActivity = true;// 当前页面是否可见

	// private Handler mCallBack = new Handler() {
	//
	// public void handleMessage(Message msg) {
	// switch (msg.what) {
	// case 1:
	// try {
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// setAvdImage();
	// setAdvTime();
	// }
	// break;
	// }
	//
	// }
	// };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(initLayoutId());
		initView();
		setAvdImage();
	}

	protected int initLayoutId() {
		return R.layout.activity_splash;
	}

	protected void initView() {
		mContext = this;
		rl_ignore = (RelativeLayout) findViewById(R.id.rl_ignore);
		img_loading = (ImageView) findViewById(R.id.img_splash);
		iv_ignore = (TextView) findViewById(R.id.iv_ignore);
		iv_ignore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivityIn();
			}
		});
		img_loading.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				click_url = "http://blog.csdn.net/fancylovejava/article/details/44747759";
				if (TextUtils.StrIsNotNull(click_url)) {
					try {
						Intent intent = new Intent();
						intent.setAction("android.intent.action.VIEW");
						if (!click_url.startsWith("http")) {
							click_url = "http://" + click_url;
						}
						Uri content_url = Uri.parse(click_url);
						intent.setData(content_url);
						startActivity(intent);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
	}

	private void startActivityIn() {
		int id = 2;
		switch (id) {
		case 1:
			Intent i = new Intent(mContext, ViewPagerImgActivity.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			finish();
			break;
		case 2:
			Intent i2 = new Intent(mContext, TabMainActivity.class);
			startActivity(i2);
			finish();
			break;
		case 3:
			Intent i3 = new Intent(mContext, LoginActivity.class);
			startActivity(i3);
			finish();
			break;
		}
	}

	/**
	 * @description 是否登陆
	 * @author yugq
	 * @data 2016-1-26
	 * @modified 修改者，修改日期，修改内容
	 * @return
	 */
	private boolean isLogin() {
		return false;
	}

	/**
	 * 
	 * @description 设置启动图
	 * @author yugq
	 * @data 2016-1-26
	 */
	private void setAvdImage() {
		image_url = "http://image80.360doc.com/DownloadImg/2014/12/2613/48457343_16.jpg";
		final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnim.setFillAfter(true);
		scaleAnim.setDuration(3000);
		scaleAnim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				Glide.with(mContext).load(image_url).into(img_loading);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				setAdvTime();
			}
		});
		img_loading.startAnimation(scaleAnim);
	}

	private void setAdvTime() {
		adv_time = 6;
		rl_ignore.setVisibility(View.VISIBLE);
		MyCountDownTimer countDownTimer = new MyCountDownTimer(adv_time * 1000, 1000);
		countDownTimer.start();
	}

	@Override
	protected void onResume() {
		super.onResume();
		isTopActivity = true;
		if (timeOut) {
			startActivityIn();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		isTopActivity = false;
	}

	/**
	 * 
	 * @description 实现计时功能
	 * @author yugq
	 * @data 2016-1-4
	 */
	class MyCountDownTimer extends CountDownTimer {

		public MyCountDownTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			timeOut = true;
			if (mContext != null && !mContext.isFinishing()) {
				if (isTopActivity) {
					startActivityIn();
				}
			}
		}

		@Override
		public void onTick(long millisUntilFinished) {
			if (mContext != null && !mContext.isFinishing()) {
				String setTime = millisUntilFinished / 1000 + getString(R.string.ignore);
				iv_ignore.setText(setTime);
			}
		}

	}

}
