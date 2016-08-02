package com.gx303.framedemo.com.gx303.framedemo.listviewdemo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gx303.framedemo.R;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2015/6/30.
 */
public abstract  class FastAdapterListView<T> extends BaseAdapter {
    List<T> mDatas;
    private LayoutInflater mInflater;
    private Context mContext;
    private int listViewItemLayout;
    public FastAdapterListView(Context context,List<T> mDatas,int listViewItemLayout)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.listViewItemLayout=listViewItemLayout;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(listViewItemLayout, parent,
                    false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convert(viewHolder,mDatas.get(position));
        return convertView;
    }
    public abstract void convert(ViewHolder helper, T item);
    static class ViewHolder
    {
        SparseArray viewmap;
        View convertView;
        public ViewHolder(View convertView)
        {
            this.convertView=convertView;
            viewmap=new SparseArray();
        }
        public <T1 extends View> T1 getView(int id)
        {
            if(viewmap.get(id,-1)!=-1)
            {
                return (T1)viewmap.get(id);
            }
            else
            {
                T1 tv1= (T1)convertView.findViewById(id);
                viewmap.put(id,tv1);
                return  tv1;
            }
        }
    }
}
