package com.mikexapp.mikex.mikexapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.mikexapp.mikex.mikexapp.R;

public class AppStartActivity extends Activity implements View.OnClickListener{

    private Button mBtnStartApp;
    private Button mBtnStartGL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        initView();
    }

    private void initView() {
        mBtnStartApp = (Button) findViewById(R.id.btn_start_app);
        mBtnStartApp.setOnClickListener(this);
        mBtnStartGL = (Button) findViewById(R.id.btn_start_gl);
        mBtnStartGL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_app:
                Intent intentHomeAppActivity = new Intent();
                intentHomeAppActivity.setClass(AppStartActivity.this,HomeAppActivity.class);
                startActivity(intentHomeAppActivity);
                break;
            case R.id.btn_start_gl:
                Intent intentGLActivity = new Intent();
                intentGLActivity.setClass(AppStartActivity.this,HomeGLActivity.class);
                startActivity(intentGLActivity);
                break;
            default:
                break;
        }
    }

}
