package com.xunmnengwuya.cornucopia.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Candy on 2015/9/14.
 */
public class ToastUtils {

    public void ToashShort(String msg) {
        Context context = CornucopiaApplication.getContext();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
