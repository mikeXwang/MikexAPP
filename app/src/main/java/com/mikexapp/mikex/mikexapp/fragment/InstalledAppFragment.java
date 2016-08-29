package com.mikexapp.mikex.mikexapp.fragment;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.adapter.InstalledAppAdapter;
import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstalledAppFragment extends AppBaseFragment {

    private List<AppInfo> mInstalledApps;
    private ListView mListView;
    private InstalledAppAdapter mInstalledAppAdapter;
    public InstalledAppFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installed_app, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view_installed_app);
        new Thread(new InstalledAPPTask()).start();
        return view;
    }


    //获取系统应用
    private Handler handler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch(what) {
                case 0 :
                    mInstalledApps = (List<AppInfo>) msg.obj;
                    mInstalledAppAdapter = new InstalledAppAdapter(getActivity(), mInstalledApps);
                    mListView.setAdapter(mInstalledAppAdapter);
                    break;
            }
        }

    };

    private class InstalledAPPTask implements Runnable {
        @Override
        public void run() {
            List<AppInfo> appList = achieveAPPList();
            handler.sendMessage(handler.obtainMessage(0, appList));
        }
        private List<AppInfo> achieveAPPList() {
            List<AppInfo> result = new ArrayList<AppInfo>();

            List<PackageInfo> packageInfoList = getActivity().getPackageManager().getInstalledPackages(0); //返回已安装的包信息列表
            for(PackageInfo packageInfo : packageInfoList) {
                /*
                 * 判断是否为非系统应用
                 * */
                if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) ==0){
                    AppInfo app = new AppInfo();
                    app.setAppIcon(packageInfo.applicationInfo.loadIcon(getActivity().getPackageManager()));
                    app.setAppLabel(packageInfo.applicationInfo.loadLabel(getActivity().getPackageManager()).toString());
                    app.setPkgName(packageInfo.packageName);
                    app.setVersionName(packageInfo.versionName);
                    result.add(app);
                }
            }
            return result;

        }

    }
}
