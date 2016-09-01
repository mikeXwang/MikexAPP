package com.mikexapp.mikex.mikexapp.fragment;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.adapter.InstalledAppAdapter;
import com.mikexapp.mikex.mikexapp.adapter.StoreCardAppAdapter;
import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreCardApkFragment extends AppBaseFragment {
    private ArrayList<AppInfo> mStoreCardApps;
    private ListView mListView;
    private StoreCardAppAdapter mStoreCardAppAdapter;

    public StoreCardApkFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_store_card_app, container, false);
        mStoreCardApps = new ArrayList<AppInfo>();
        doSearch(new File("/sdcard/apks"));
        mListView = (ListView) view.findViewById(R.id.list_view_store_card_app);
        mStoreCardAppAdapter = new StoreCardAppAdapter(getActivity(), mStoreCardApps);
        mListView.setAdapter(mStoreCardAppAdapter);
//        mListView.setOnItemClickListener();
        return view;
    }


    /**
     * Notes:此处方法不应该放在主线程中，会造成页面卡顿，这里仅仅作调试使用
     * <p>
     * This function should not add in main thread.
     * We add it here just for testing!!!!
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void doSearch(File file) {

        if (!file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (File f : files) {
                if (f.isFile()) {
                    if (!f.toString().endsWith(".apk")) {
                        return;
                    }
                    AppInfo appinfo = new AppInfo();
                    appinfo.setAppIcon(getApkIcon(getActivity(),f.getAbsolutePath()));
                    appinfo.setPkgName(f.getAbsolutePath());
                    mStoreCardApps.add(appinfo);
                } else if (f.isDirectory()) {
                    doSearch(f);
                }
            }
        }

    }

    public static Drawable getApkIcon(Context context, String apkPath) {
        PackageManager pm = context.getPackageManager();
        PackageInfo info = pm.getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES);
        if (info != null) {
            ApplicationInfo appInfo = info.applicationInfo;
            appInfo.sourceDir = apkPath;
            appInfo.publicSourceDir = apkPath;
            try {
                return appInfo.loadIcon(pm);
            } catch (OutOfMemoryError e) {
                Log.e("ApkIconLoader", e.toString());
            }
        }
        return null;
    }

}
