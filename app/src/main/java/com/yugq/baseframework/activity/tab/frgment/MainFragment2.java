package com.yugq.baseframework.activity.tab.frgment;

import android.widget.TextView;

import com.yugq.baseframework.R;
import com.yugq.baseframework.common.BaseFragment;

/**
 * Copyright (C) Shenzhen nykj Technology Co.Ltd.All right reserved.
 *
 * @author : yugq
 * @date ${date}
 */
public class MainFragment2 extends BaseFragment {

    private TextView tv_news;

    @Override
    protected int setBaseView() {
        return R.layout.fragment_tab_new2s;
    }


    @Override
    protected void initView() {
//        tv_news = (TextView)baseView.findViewById(R.id.tv_news);
    }

    @Override
    protected void initData() {
//        tv_news.setText("这是第二个页面");
    }
}
