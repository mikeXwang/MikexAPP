package com.mikexapp.mikex.mikexapp.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.mikexapp.mikex.mikexapp.render.AppBaseRender;

/**
 * Created by mike on 16-8-27.
 */

public class AppBaseGLSurfaceView extends GLSurfaceView {
    private AppBaseRender mRender;
    public AppBaseGLSurfaceView(Context context) {
        super(context);
        try {
            setEGLContextClientVersion(2);
            mRender = new AppBaseRender();
            this.setRenderer(mRender);
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public AppBaseGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRender = new AppBaseRender();
        this.setRenderer(mRender);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
