package com.yugq.baseframework.activity.tab.frgment;

import android.widget.TextView;

import com.yugq.baseframework.R;
import com.yugq.baseframework.common.BaseFragment;

/**
 *
 * @author : yugq
 * @date ${date}
 */
public class MainFragment3 extends BaseFragment {

    private TextView tv_news;

    @Override
    protected int setBaseView() {
        return R.layout.fragment_tab_news3;
    }

    @Override
    protected void initView() {
//        tv_news = (TextView)baseView.findViewById(R.id.tv_news);
    }

    @Override
    protected void initData() {
//        tv_news.setText("这是第三个页面");
    }
}
