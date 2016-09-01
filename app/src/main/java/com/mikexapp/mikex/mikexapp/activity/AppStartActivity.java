package com.mikexapp.mikex.mikexapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.mikexapp.mikex.mikexapp.R;

public class AppStartActivity extends Activity {

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
        mBtnStartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AppStartActivity.this,HomeAppActivity.class);
                startActivity(intent);
            }
        });
    }

}
