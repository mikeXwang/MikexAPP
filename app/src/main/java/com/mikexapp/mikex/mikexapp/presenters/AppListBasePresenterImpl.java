package com.mikexapp.mikex.mikexapp.presenters;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.widget.Toast;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.interfaces.FragmentViewInterface;
import com.mikexapp.mikex.mikexapp.interfaces.IAppListBasePresenter;
import com.mikexapp.mikex.mikexapp.model.AppInfo;
import com.mikexapp.mikex.mikexapp.utils.ConstantsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyong on 16-8-27.
 */
public class AppListBasePresenterImpl implements IAppListBasePresenter {

    protected Context mContext;
    protected FragmentViewInterface mFragmentViewInterface;

    public AppListBasePresenterImpl(Context context, FragmentViewInterface fragmentViewInterface) {
        this.mFragmentViewInterface = fragmentViewInterface;
        mContext = context;
    }

    public void getAppsList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<AppInfo> appList = achieveAppList();
                mFragmentViewInterface.FinishedLoadAppsList(appList);
            }
        }).start();

    }

    public List<AppInfo> achieveAppList() {
        List<AppInfo> result = new ArrayList<AppInfo>();

        List<PackageInfo> packageInfoList = mContext.getPackageManager().getInstalledPackages(0); //返回已安装的包信息列表
        for(PackageInfo packageInfo : packageInfoList) {
                /*
                 * used to make a judgement that if this is a system app
                 * */
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) ==0){
                AppInfo app = new AppInfo();
                app.setAppIcon(packageInfo.applicationInfo.loadIcon(mContext.getPackageManager()));
                app.setAppLabel(packageInfo.applicationInfo.loadLabel(mContext.getPackageManager()).toString());
                app.setPkgName(packageInfo.packageName);
                app.setVersionName(packageInfo.versionName);
                result.add(app);
            }
        }
        return result;
    }

    @Override
    public void startApp(int startType, AppInfo appInfo) {
        switch (startType) {
            case ConstantsUtils.START_TYPE_PACKAGE_NAME:
                try {
                    Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(appInfo.getPkgName());
                    mContext.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(mContext, R.string.not_installed, Toast.LENGTH_SHORT).show();
                }
                break;
            case ConstantsUtils.START_TYPE_FILE_PATH:
                //TO-DO add respond logic here
                break;
            case ConstantsUtils.START_TYPE_NET_PATH:
                //TO-DO add respond logic here
                break;
            case ConstantsUtils.START_TYPE_UNKNOWN:
                //TO-DO add respond logic here
                break;
            default:
                //TO-DO add respond logic here
                break;
        }
    }
}
