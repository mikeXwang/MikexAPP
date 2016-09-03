package com.mikexapp.mikex.mikexapp.interfaces;

import android.content.Context;

import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-9-4.
 */

public interface IAppListBasePresenter {

    Context mContext = null;

    FragmentViewInterface mFragmentViewInterface = null;

    void getAppsList();

    List<AppInfo> achieveAppList();

    void startApp(int startType, AppInfo appInfo);
}
