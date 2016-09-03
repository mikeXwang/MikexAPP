package com.mikexapp.mikex.mikexapp.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.adapter.AppBaseAdapter;
import com.mikexapp.mikex.mikexapp.interfaces.FragmentViewInterface;
import com.mikexapp.mikex.mikexapp.model.AppInfo;
import com.mikexapp.mikex.mikexapp.presenters.AppListBasePresenterImpl;
import com.mikexapp.mikex.mikexapp.utils.ConstantsUtils;

import java.util.List;

/**
 * Created by mike on 16-8-28.
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class AppBaseFragment extends Fragment implements FragmentViewInterface,AdapterView.OnItemClickListener{


    protected List<AppInfo> mAppsList;
    protected ListView mListView;
    protected AppBaseAdapter mAppsAdapter;
    protected AppListBasePresenterImpl mBasePresenter;
    protected Context mContext;

    protected int mStartType;


    public AppBaseFragment() {
    }

    public static AppBaseFragment newInstance(Bundle bundle){
        AppBaseFragment fragment = new AppBaseFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getActivity();
        this.mBasePresenter = new AppListBasePresenterImpl(mContext,this);
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installed_app, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view_installed_app);
        this.mStartType = getArguments().getInt(ConstantsUtils.START_TYPE);
        startLoadAppsList();
        return view;
    }

    protected Handler handler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch(what) {
                case 0 :
                    mAppsList = (List<AppInfo>) msg.obj;

                    //-------------------------------------------------------------
                    //！！！！！！！！！！！此处存在问题，暂时放在这里：adapter更新
                    //-------------------------------------------------------------
                    mAppsAdapter = new AppBaseAdapter(getActivity(), mAppsList,mStartType);
                    mListView.setAdapter(mAppsAdapter);
                    mListView.setOnItemClickListener(AppBaseFragment.this);

                    refreshFragment();
                    break;
            }
        }

    };

    @Override
    public void startLoadAppsList() {
        mBasePresenter.getAppsList();
    }

    @Override
    public void FinishedLoadAppsList(List<AppInfo> appInfoList) {
        mAppsList = appInfoList;
        handler.sendMessage(handler.obtainMessage(0, appInfoList));
    }

    @Override
    public void refreshFragment() {
        mAppsAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppInfo appInfo = (AppInfo) mAppsAdapter.getItem(position);
        mBasePresenter.startApp(mStartType,appInfo);
    }


}
