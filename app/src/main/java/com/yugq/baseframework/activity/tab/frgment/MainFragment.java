package com.yugq.baseframework.activity.tab.frgment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.yugq.baseframework.R;
import com.yugq.baseframework.common.BaseFragment;
import com.yugq.baseframework.common.EasyBaseAdapter;
import com.yugq.baseframework.common.EasyViewHolder;
import com.yugq.baseframework.activity.tab.entity.SampleInfo;
import com.yugq.baseframework.utils.GsonImpl;
import com.yugq.baseframework.view.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment {

    private ListView lv_news;
    private List<SampleInfo.LinksEntity> mlist = new ArrayList<>();
    private MyAdapter adapter = null;
    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0:
                    try {
                        SampleInfo info = GsonImpl.get().toObject("{\n" +
                                "    \"name\": \"BeJson\",\n" +
                                "    \"url\": \"http://www.bejson.com\",\n" +
                                "    \"page\": 88,\n" +
                                "    \"isNonProfit\": true,\n" +
                                "    \"address\": {\n" +
                                "        \"street\": \"科技园路.\",\n" +
                                "        \"city\": \"江苏苏州\",\n" +
                                "        \"country\": \"中国\"\n" +
                                "    },\n" +
                                "    \"links\": [\n" +
                                "        {\n" +
                                "            \"name\": \"Google\",\n" +
                                "            \"url\": \"http://www.google.com\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"name\": \"Baidu\",\n" +
                                "            \"url\": \"http://www.baidu.com\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"name\": \"SoSo\",\n" +
                                "            \"url\": \"http://www.SoSo.com\"\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}", SampleInfo.class);
                        mlist = info.getLinks();
                        adapter.updateListView(mlist);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    private TitleView titleView;


    @Override
    protected int setBaseView() {
        return R.layout.fragment_tab_news;
    }

    @Override
    protected void initView() {
        titleView = (TitleView) baseView.findViewById(R.id.title_bar);
        titleView.setTitle("这个是标题");
        titleView.setvisible(View.VISIBLE,View.VISIBLE,View.VISIBLE);
        lv_news = (ListView) baseView.findViewById(R.id.lv_news);
        adapter = new MyAdapter(mContext,R.layout.item_tab_news,mlist);
        lv_news.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        handler.sendEmptyMessage(0);
    }

    class MyAdapter extends EasyBaseAdapter<SampleInfo.LinksEntity> {
        private TextView mTv_content;
        private TextView mTv_time;
        private TextView mTv_prise;
        public MyAdapter(Context context, int layoutId, List<SampleInfo.LinksEntity> list) {
            super(context, layoutId, list);
        }

        @Override
        public void convert(EasyViewHolder viewHolder, SampleInfo.LinksEntity linksEntity) {
            mTv_content = viewHolder.getTextView(R.id.tv_content);
            mTv_time = viewHolder.getTextView(R.id.tv_time);
            mTv_prise = viewHolder.getTextView(R.id.tv_prise);
            mTv_content.setText(linksEntity.getName());
            mTv_time.setText(linksEntity.getUrl());
        }
    }
}
