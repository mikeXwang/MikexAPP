package com.mikexapp.mikex.mikexapp;

/**
 * Created by mike on 16-8-27.
 */


/**
 * This is left for NDK interface demo
 * Ndk configuration is as follows:
 * 1.add a java file like this file.It include the interface with native announcement which you need
 * 2.run javah to generate .h file
 * 3.add config in build.gradle
 * 4.loadlibrary
 * 5.use the interface
 *
 *
 */
public class JNITest {


    static {
        System.loadLibrary("jniTest");
    }
    public native static int add(int a,int b);
}
