package com.xunmnengwuya.cornucopia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xunmnengwuya.cornucopia.utils.ActivityManager;
import com.xunmnengwuya.cornucopia.utils.BaseActivity;


public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this, R.layout.activity_setting);
    }

}
