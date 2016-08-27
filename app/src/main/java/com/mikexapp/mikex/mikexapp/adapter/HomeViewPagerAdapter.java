package com.mikexapp.mikex.mikexapp.adapter;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mike on 16-8-28.
 */

public class HomeViewPagerAdapter extends PagerAdapter {
    private final FragmentManager fm;
    private FragmentTransaction transaction;
    private ArrayList<Fragment> mFragmentList;

    public HomeViewPagerAdapter(android.app.FragmentManager fm, ArrayList<Fragment> fragments) {
        this.fm = fm;
        this.mFragmentList = fragments;
    }

    @SuppressLint("NewApi")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        transaction = fm.beginTransaction();
        String tag = "";
        switch (position) {
            case 1:
                tag = "FirstFragment";
                break;
            case 2:
                tag = "SecondFragment";
                break;
            case 3:
                tag = "ThirdFragment";
                break;
            default:
                break;
        }

        Fragment fragment = mFragmentList.get(position);
        transaction.attach(fragment);
        transaction.add(container.getId(), fragment, tag);
        transaction.commit();
        return fragment;
    }

    @SuppressLint("NewApi")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        transaction = fm.beginTransaction();
        Fragment fragment = mFragmentList.get(position);
        transaction.detach(fragment);
        transaction.remove(fragment);
        transaction.commit();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }
}
