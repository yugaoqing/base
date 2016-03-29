package com.yugq.baseframework.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yugq.baseframework.R;

/**
 * 自定义titlebar
 * 
 * @author yugq
 * 
 */
public class TitleView extends FrameLayout {
	private Button btn_top_back;
	private TextView tv_top_title;
	private Button btn_top_right;
	private ImageView iv_top_title_choice;

	public TitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.include_titlebar, this);
		btn_top_back = (Button) findViewById(R.id.btn_top_back);
		tv_top_title = (TextView) findViewById(R.id.tv_top_title);
		btn_top_right = (Button) findViewById(R.id.btn_top_right);
		iv_top_title_choice = (ImageView) findViewById(R.id.iv_top_title_choice);
	}
	
	public Button getRightButton(){
		return btn_top_right;
	}

	/**
	 * @param left
	 *            title左侧组件是否隐藏
	 * @param middle
	 *            title是否隐藏
	 * @param right
	 *            title右侧组件是否隐藏
	 */
	public void setvisible(int left, int middle, int right) {
		btn_top_back.setVisibility(left);
		tv_top_title.setVisibility(middle);
		btn_top_right.setVisibility(right);
	}
	/**
	 * @param left
	 *            title左侧组件是否隐藏
	 * @param middle
	 *            title是否隐藏
	 * @param right
	 *            title右侧组件是否隐藏
	 */
	public void setvisible(int left, int middle, int right,int right2) {
		btn_top_back.setVisibility(left);
		tv_top_title.setVisibility(middle);
		btn_top_right.setVisibility(right);
		iv_top_title_choice.setVisibility(right2);
	}

	/**
	 * @param title
	 *            设置String内容的title名称
	 */
	public void setTitle(String title) {
		tv_top_title.setText(title);
	}

	/**
	 * @param title
	 *            设置R.String.XXX的title名称
	 */
	public void setTitle(int title) {
		tv_top_title.setText(title);
	}

	/**
	 * 左侧按钮单击事件
	 * 
	 * @param onClickListener
	 */
	public void setLeftOnclickListener(OnClickListener onClickListener) {
		btn_top_back.setOnClickListener(onClickListener);
	}

	/**
	 * 右侧按钮单击事件
	 * 
	 * @param onClickListener
	 */
	public void setRightOnclickListener(OnClickListener onClickListener) {
		btn_top_right.setOnClickListener(onClickListener);
	}

	/**
	 * @param text
	 *            右侧按钮显示内容
	 */
	public void setRightText(String text) {
		btn_top_right.setText(text);
	}

	/**
	 * 设置右侧按钮的背景图片
	 * 
	 * @param resId
	 */
	public void setRightBackGround(int resId) {
		Drawable drawable = getResources().getDrawable(resId);
		// btn_top_right.setBackgroundResource(resId);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
		btn_top_right.setCompoundDrawables(null, null, drawable, null);
	}
	/**
	 * 设置中title的右图片
	 * 
	 * @param resId
	 */
//	public void setTitleRightDrawable(int resId) {
//		Drawable drawable = getResources().getDrawable(resId);
//		// btn_top_right.setBackgroundResource(resId);
//		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//		tv_top_title.setCompoundDrawables(null, null, drawable, null);
//	}

}
