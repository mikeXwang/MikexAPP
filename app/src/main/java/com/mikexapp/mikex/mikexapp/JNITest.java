package com.mikexapp.mikex.mikexapp;

/**
 * Created by mike on 16-8-27.
 */

public class JNITest {


    static {
        System.loadLibrary("jniTest");
    }
    public native static int add(int a,int b);
}
