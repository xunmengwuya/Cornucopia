package com.xunmnengwuya.cornucopia;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xunmnengwuya.cornucopia.adapter.MainViewAdapter;
import com.xunmnengwuya.cornucopia.utils.ActivityManager;
import com.xunmnengwuya.cornucopia.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2Activity extends BaseActivity {

    private ViewPager viewPager;
    private View snatchView;
    private View listView;
    private View tobeOpenView;
    private View myView;
    private List<View> viewList;
    private MainViewAdapter mainViewAdapter;
    private RadioGroup rgBottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this, R.layout.activity_main_activity2);
        findViews();
        initViewPager();
        initViewEvent();
    }

    private void findViews() {
        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        rgBottomBar = (RadioGroup) findViewById(R.id.main_rg_bottom_bar);
        ((RadioButton) rgBottomBar.getChildAt(0)).setChecked(true);
    }

    private void initViewEvent() {
        viewPager.setOnPageChangeListener(viewpagerOnPagerChangeListener);
    }

    private void initViewPager() {
//
        viewList = new ArrayList<>();
        viewList.add(getLayoutInflater().inflate(R.layout.layout_snatch, null));
        viewList.add(getLayoutInflater().inflate(R.layout.layout_tobe_open, null));
        viewList.add(getLayoutInflater().inflate(R.layout.layout_list, null));
        viewList.add(getLayoutInflater().inflate(R.layout.layout_my, null));
        mainViewAdapter = new MainViewAdapter(viewList);
        viewPager.setAdapter(mainViewAdapter);

    }

    private ViewPager.OnPageChangeListener viewpagerOnPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            ((RadioButton) rgBottomBar.getChildAt(position)).setChecked(true);
            switch (position) {
                case 0:
//                    Toast.makeText(MainActivity2Activity.this, "页面" + position, Toast.LENGTH_SHORT).show();
                    break;
                case 1:
//                    Toast.makeText(MainActivity2Activity.this, "页面" + position, Toast.LENGTH_SHORT).show();
                    break;
                case 2:
//                    Toast.makeText(MainActivity2Activity.this, "页面" + position, Toast.LENGTH_SHORT).show();
                    break;
                case 3:
//                    Toast.makeText(MainActivity2Activity.this, "页面" + position, Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
