package com.mikexapp.mikex.mikexapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv4Test;
    private Button mBtnTestNDK;

    private int a = 1;
    private int b = 1;
    private int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initView();
    }

    private void initView() {

        mTv4Test = (TextView) findViewById(R.id.tv_first_step);
        mBtnTestNDK = (Button) findViewById(R.id.btn_test_ndk);
        mBtnTestNDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = JNITest.add(a,b);
                mTv4Test.setText(String.valueOf(result));
            }
        });
    }

}
