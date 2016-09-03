package com.mikexapp.mikex.mikexapp.interfaces;

import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-9-4.
 */

public interface FragmentViewInterface {

    public void startLoadAppsList();
    public void FinishedLoadAppsList(List<AppInfo> appInfoList);
    public void refreshFragment();

}
