package com.xunmnengwuya.cornucopia.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Candy on 2015/8/30.
 */
public class CornucopiaApplication extends Application {

    private static CornucopiaApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static void exit() {
        ActivityManager.clearAllActivity();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static Context getContext() {
        return application.getContext();

    }
}
