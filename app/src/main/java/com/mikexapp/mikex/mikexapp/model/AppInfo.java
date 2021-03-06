package com.mikexapp.mikex.mikexapp.model;

/**
 * Created by mike on 16-8-29.
 * Model,used for describe app info
 */


import android.content.Intent;
import android.graphics.drawable.Drawable;


public class AppInfo {

    private String appLabel;    //应用程序标签
    private Drawable appIcon ;  //应用程序图像
    private Intent intent ;     //启动应用程序的Intent ，一般是Action为Main和Category为Lancher的Activity
    private String pkgName ;    //应用程序所对应的包名

    private String packageName; //包名
    private String versionName; //版本名

    public AppInfo() {}

    public AppInfo(Drawable appIcon, String pkgName, Intent intent, String appLabel){
        this.appLabel = appLabel;
        this.appIcon = appIcon;
        this.intent = intent;
        this.pkgName = pkgName;
    }

    public String getAppLabel() {
        return appLabel;
    }
    public void setAppLabel(String appName) {
        this.appLabel = appName;
    }
    public Drawable getAppIcon() {
        return appIcon;
    }
    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }
    public Intent getIntent() {
        return intent;
    }
    public void setIntent(Intent intent) {
        this.intent = intent;
    }
    public String getPkgName(){
        return pkgName ;
    }
    public void setPkgName(String pkgName){
        this.pkgName=pkgName ;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

}