package com.lewish.start.jpushtest;

import android.app.Application;

/**
 * author: sundong
 * created at 2017/7/27 9:43
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PushManager.getInstance().init(this);
    }
}
