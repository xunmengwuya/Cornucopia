package com.xunmnengwuya.cornucopia;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import com.xunmnengwuya.cornucopia.adapter.GridViewAdapter;
import com.xunmnengwuya.cornucopia.adapter.MainViewAdapter;
import com.xunmnengwuya.cornucopia.utils.ActivityManager;
import com.xunmnengwuya.cornucopia.utils.BaseActivity;
import com.xunmnengwuya.cornucopia.utils.ConvertUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity2Activity extends BaseActivity {

    private ViewPager viewPager;
    private View snatchView;
    private View listView;
    private View tobeOpenView;
    private View myView;
    private List<View> viewList;
    private GridView myGridView;
    private MainViewAdapter mainViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private RadioGroup rgBottomBar;

    private LinearLayout llMySetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this, R.layout.activity_main_activity2);
        findViews();
        initViewPager();
        findSonPageViews();
        initPageData();
        initViewEvent();
    }

    private void findViews() {
        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        rgBottomBar = (RadioGroup) findViewById(R.id.main_rg_bottom_bar);
    }


    private void initViewPager() {
        viewList = new ArrayList<>();
        snatchView = getLayoutInflater().inflate(R.layout.layout_snatch, null);
        myView = getLayoutInflater().inflate(R.layout.layout_my, null);
        listView = getLayoutInflater().inflate(R.layout.layout_list, null);
        tobeOpenView = getLayoutInflater().inflate(R.layout.layout_tobe_open, null);
        viewList.add(snatchView);
        viewList.add(tobeOpenView);
        viewList.add(listView);
        viewList.add(myView);
        mainViewAdapter = new MainViewAdapter(viewList);
        viewPager.setAdapter(mainViewAdapter);
    }

    private void initPageData() {
        ((RadioButton) rgBottomBar.getChildAt(0)).setChecked(true);
        //  bindMyPageData();

    }


    private void findSonPageViews() {
        llMySetting = (LinearLayout) myView.findViewById(R.id.my_ll_setting);

    }

    private void initViewEvent() {
        viewPager.setOnPageChangeListener(viewpagerOnPagerChangeListener);
        rgBottomBar.setOnCheckedChangeListener(rgOnCheckChangedListener);

        llMySetting.setOnClickListener(MyMenuOnclickListener);
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

    private RadioGroup.OnCheckedChangeListener rgOnCheckChangedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton checkRadioButton = (RadioButton) findViewById(checkedId);
            int tag = ConvertUtils.getInteger(checkRadioButton.getTag());
            if (viewPager.getCurrentItem() == tag) {
                return;
            }
            viewPager.setCurrentItem(tag, true);

        }
    };


    private View.OnClickListener MyMenuOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.my_ll_setting:
                    gotoSonActivity(SettingActivity.class);
                    break;
                default:
                    break;
            }
        }
    };


    private void gotoSonActivity(Class gotoClass) {
        Intent intent = new Intent(MainActivity2Activity.this, gotoClass);
        startActivity(intent);
    }


    // ********处理夺宝页面  begin***********
    //*********处理夺宝页面  begin***********

    // ********我的页面  begin***********



    //*********我的页面  begin***********

    private void findMyViews() {
    }
//*********我的页面  end***********
}
