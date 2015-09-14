package com.xunmnengwuya.cornucopia.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.xunmnengwuya.cornucopia.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Candy on 2015/7/31.
 */
public class ActivityManager {

    private static List<BaseActivity> activityList = new ArrayList<>();

    public static void addActivity(BaseActivity activity, int layoutId) {
        addActivity(activity);
        View view = LayoutInflater.from(activity).inflate(layoutId, null);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true, activity);
//
//        }
        addActivity(activity, view);
    }

    @TargetApi(19)
    private static void setTranslucentStatus(boolean on, BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintColor(activity.getResources().getColor(R.color.pink));
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    public static void addActivity(BaseActivity activity, View view) {
        addActivity(activity);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//            tintManager.setStatusBarTintColor(activity.getResources().getColor(R.color.pink));
//            tintManager.setStatusBarTintEnabled(true);
//        }
        activity.setContentView(view);
//        activity.mProgressControl = new ProgressControl(activity, view);
    }

    public static void addActivity(BaseActivity activity) {
        activityList.add(activity);
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(activity);
    }

    public static void exit() {
        clearAllActivity();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void clearAllActivity() {
        for (Activity activity : activityList) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
