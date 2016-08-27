package com.mikexapp.mikex.mikexapp.view;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.mikexapp.mikex.mikexapp.render.AppBaseRender;

/**
 * Created by mike on 16-8-27.
 */

public class AppBaseGLSurfaceView extends GLSurfaceView {
    public AppBaseGLSurfaceView(Context context) {
        super(context);
        try {
            setEGLContextClientVersion(2);
            setRenderer(new AppBaseRender());
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
