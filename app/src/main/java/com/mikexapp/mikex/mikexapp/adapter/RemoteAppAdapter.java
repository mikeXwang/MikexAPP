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
 * Created by mike on 16-8-29.
 */

public class RemoteAppAdapter extends BaseAdapter {

    private List<AppInfo> mRemoteApps;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public RemoteAppAdapter(Context context, List<AppInfo> remoteApps) {
        this.mContext = context;
        this.mRemoteApps = remoteApps;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mRemoteApps.size();
    }

    @Override
    public Object getItem(int position) {
        return mRemoteApps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;

        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.item_remote_app, null);
            viewHolder = new ViewHolder();
            viewHolder.mImageViewHolder = (ImageView) view.findViewById(R.id.iv_item_remote_app);
            viewHolder.mTextViewHolder = (TextView) view.findViewById(R.id.tv_item_remote_app);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
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

