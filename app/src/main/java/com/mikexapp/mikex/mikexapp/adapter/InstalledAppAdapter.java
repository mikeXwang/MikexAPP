package com.mikexapp.mikex.mikexapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by mike on 16-8-29.
 */

public class InstalledAppAdapter extends BaseAdapter {

    private List<AppInfo> mInstalledApps;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public InstalledAppAdapter(Context context,List<AppInfo> installedApps) {
        this.mContext = context;
        this.mInstalledApps = installedApps;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mInstalledApps.size();
    }

    @Override
    public Object getItem(int position) {
        return mInstalledApps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;

        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.item_installed_app, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppInfo appinfo = (AppInfo) getItem(position);
                    startAppByPackageName(appinfo.getPkgName());
                }
            });
            viewHolder = new ViewHolder();
            viewHolder.mImageViewHolder = (ImageView) view.findViewById(R.id.iv_item_installed_app);
            viewHolder.mTextViewHolder = (TextView) view.findViewById(R.id.tv_item_installed_app);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final AppInfo titleData = (AppInfo) getItem(position);
        viewHolder.mTextViewHolder.setText(titleData.getPkgName());
        viewHolder.mImageViewHolder.setImageDrawable(titleData.getAppIcon());

        return view;
    }

    private void startAppByPackageName(String pkgName) {
        try{
            Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(pkgName);
            mContext.startActivity(intent);
        }catch(Exception e){
            Toast.makeText(mContext, "没有安装", Toast.LENGTH_LONG).show();
        }
    }

    class ViewHolder {
        protected ImageView mImageViewHolder;
        protected TextView mTextViewHolder;
    }
}

