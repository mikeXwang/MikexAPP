package com.mikexapp.mikex.mikexapp.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.adapter.HomeViewPagerAdapter;
import com.mikexapp.mikex.mikexapp.fragment.InstalledAppFragment;
import com.mikexapp.mikex.mikexapp.fragment.RemoteApkFragment;
import com.mikexapp.mikex.mikexapp.fragment.StoreCardApkFragment;

import java.util.ArrayList;

public class HomeAppActivity extends AppBaseActivity implements ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;
    private ArrayList<Fragment> mFragmentList;

    private TextView mTextInstalled = null;
    private TextView mTextSdCard = null;
    private TextView mTextRemote = null;
    private LinearLayout mLinearLayoutInstalled = null;
    private LinearLayout mLinearLayoutSdCard = null;
    private LinearLayout mLinearLayoutRemote = null;
    private ImageView mImgLine;

    private int mSelectColor;
    private int mUnselectColor;

    private int mPageOfScreen;

    private Integer mViewPagerW = 0;

    private static int sWidth = 0;
    private InstalledAppFragment mInstalledPage;
    private StoreCardApkFragment mStoreCardPage;
    private RemoteApkFragment mRemotePage;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLine();
        initView();
        initFragment();
    }

    private void initLine() {
        mImgLine = (ImageView) findViewById(R.id.img_line);
        mPageOfScreen = getScreenWidth(this) / 3;
        ViewGroup.LayoutParams lp = mImgLine.getLayoutParams();
        lp.width = mPageOfScreen;
        mImgLine.setLayoutParams(lp);
    }

    private void initView() {

        mSelectColor = getResources().getColor(R.color.text_orange);
        mUnselectColor = getResources().getColor(R.color.black);

        mTextInstalled = (TextView) findViewById(R.id.tv_tab_installed_app);
        mTextSdCard = (TextView) findViewById(R.id.tv_tab_sd_app);
        mTextRemote = (TextView) findViewById(R.id.tv_tab_remote_app);

        mLinearLayoutInstalled = (LinearLayout) findViewById(R.id.ll_installed_app);
        mLinearLayoutSdCard = (LinearLayout) findViewById(R.id.ll_sd_app);
        mLinearLayoutRemote = (LinearLayout) findViewById(R.id.ll_remote_app);

        mLinearLayoutInstalled.setOnClickListener(new MyOnClickListenser(0));
        mLinearLayoutSdCard.setOnClickListener(new MyOnClickListenser(1));
        mLinearLayoutRemote.setOnClickListener(new MyOnClickListenser(2));

        mViewPager = (ViewPager) findViewById(R.id.mViewpager);
        mFragmentList = new ArrayList<Fragment>();

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void initFragment() {
        mInstalledPage = new InstalledAppFragment();
        mStoreCardPage = new StoreCardApkFragment();
        mRemotePage = new RemoteApkFragment();
        mFragmentList.add(mInstalledPage);
        mFragmentList.add(mStoreCardPage);
        mFragmentList.add(mRemotePage);

        mPageAdapter = new HomeViewPagerAdapter(getFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrollStateChanged(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mViewPagerW = mViewPager.getWidth() + mViewPager.getPageMargin();
        LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mImgLine.getLayoutParams();

        lp.leftMargin = (int) ((int) (mPageOfScreen * position)
                + (((double) positionOffsetPixels / mViewPagerW) * mPageOfScreen));
        mImgLine.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        resetTextColor();
        switch (mViewPager.getCurrentItem()) {
            case 0:
                mTextInstalled.setTextColor(mSelectColor);
                break;
            case 1:
                mTextSdCard.setTextColor(mSelectColor);
                break;
            case 2:
                mTextRemote.setTextColor(mSelectColor);
                break;
        }
    }

    public class MyOnClickListenser implements View.OnClickListener {

        private int index = 0;

        public MyOnClickListenser(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            resetTextColor();
            switch (v.getId()) {
                case R.id.ll_installed_app:
                    mTextInstalled.setTextColor(mSelectColor);
                    break;
                case R.id.ll_sd_app:
                    mTextSdCard.setTextColor(mSelectColor);
                    break;
                case R.id.ll_remote_app:
                    mTextRemote.setTextColor(mSelectColor);
                    break;

            }
            mViewPager.setCurrentItem(index);
        }
    }

    private void resetTextColor() {
        mTextInstalled.setTextColor(mUnselectColor);
        mTextSdCard.setTextColor(mUnselectColor);
        mTextRemote.setTextColor(mUnselectColor);
    }

    public static int getScreenWidth(Context context) {
        if (sWidth == 0) {
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            sWidth = display.getWidth();
        }
        return sWidth;
    }

}
