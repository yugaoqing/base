package com.yugq.baseframework.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yugq
 * @description 基础适配器
 * @data 2016-3-29
 * @modified
 */
public abstract class EasyBaseAdapter<T> extends BaseAdapter {
    private LayoutInflater inflater;
    private int layoutId;
    private List<T> mlist = new ArrayList<T>();

    public EasyBaseAdapter(Context context, int layoutId, List<T> list) {
        super();
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.mlist = list;
    }

    /**
     * 往顶部添加数据
     *
     * @param list
     */
    public void add2Head(List<T> list) {
        mlist.addAll(0, list);
        notifyDataSetChanged();
    }

    public void clearAll() {
        mlist.clear();
        notifyDataSetChanged();
    }

    public List<T> getAllList() {
        return mlist;
    }

    /**
     * 往底部添加数据
     *
     * @param list
     */
    public void add2Bottom(List<T> list) {
        mlist.addAll(list);
        notifyDataSetChanged();
    }

    public void add2Bottom(T t) {
        mlist.add(t);
        notifyDataSetChanged();
    }

    /**
     * @param @param list 设定文件
     * @return void 返回类型
     * @throws
     * @Title: updateListView
     * @Description: TODO(更新BaseAdapter中的数据)
     */
    public void updateListView(List<T> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public T getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    /**
     * 实际显示View的方法，使用抽象方法强制调用者覆写！
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EasyViewHolder viewHolder = EasyViewHolder.getViewHolder(parent, convertView, inflater, layoutId);
        convert(viewHolder, mlist.get(position));
        return viewHolder.getConvertView();

    }

    public abstract void convert(EasyViewHolder viewHolder, T t);

}
