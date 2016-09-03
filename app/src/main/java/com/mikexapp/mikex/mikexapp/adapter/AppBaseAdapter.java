package com.mikexapp.mikex.mikexapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-8-27.
 */

public class AppBaseAdapter extends BaseAdapter {

    protected List<AppInfo> mAppsList;
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;

    protected int mStartType;

    public AppBaseAdapter(Context context,List<AppInfo> appInfoList,int startType) {
        this.mContext = context;
        this.mAppsList = appInfoList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mStartType = startType;
    }

    @Override
    public int getCount() {
        return mAppsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        AppBaseAdapter.ViewHolder viewHolder;
        View view = convertView;

        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.item_installed_app, null);
            viewHolder = new AppBaseAdapter.ViewHolder();
            viewHolder.mImageViewHolder = (ImageView) view.findViewById(R.id.iv_item_installed_app);
            viewHolder.mTextViewHolder = (TextView) view.findViewById(R.id.tv_item_installed_app);
            view.setTag(viewHolder);
        } else {
            viewHolder = (AppBaseAdapter.ViewHolder) view.getTag();
        }

        final AppInfo titleData = (AppInfo) getItem(position);
        viewHolder.mTextViewHolder.setText(titleData.getPkgName());
        viewHolder.mImageViewHolder.setImageDrawable(titleData.getAppIcon());

        return view;
    }

    class ViewHolder {
        protected ImageView mImageViewHolder;
        protected TextView mTextViewHolder;
    }
    
}
