package com.mikexapp.mikex.mikexapp.fragment;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreCardApkFragment extends AppBaseFragment {
    private List<AppInfo> mStoreCardApps;
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
        mStoreCardApps = getTitleDataList();
        mListView = (ListView) view.findViewById(R.id.list_view_store_card_app);
        mStoreCardAppAdapter = new StoreCardAppAdapter(getActivity(), mStoreCardApps);
        mListView.setAdapter(mStoreCardAppAdapter);
//        mListView.setOnItemClickListener();
        return view;
    }


    /**
     * Notes:此处方法不应该放在主线程中，会造成页面卡顿，这里仅仅作调试使用
     *
     * This function should not add in main thread.
     * We add it here just for testing!!!!
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private List<AppInfo> getTitleDataList() {
        List<AppInfo> listItem = new ArrayList<AppInfo>();
        for(int i = 0; i < 20; i++) {
            AppInfo data = new AppInfo(getActivity().getResources().getDrawable(R.drawable.abc_btn_check_material),"Application in SD card  " + i, null,null);
            Log.d("www","data :"+data.getPkgName());
            listItem.add(data);
        }
        return listItem;
    }

}
