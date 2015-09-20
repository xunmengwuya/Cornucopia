package com.xunmnengwuya.cornucopia;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this, R.layout.activity_main_activity2);
        findViews();
        initViewPager();
        findMyViews();
        initPageData();

        initViewEvent();
    }

    private void findViews() {
        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        rgBottomBar = (RadioGroup) findViewById(R.id.main_rg_bottom_bar);
    }


    private void initViewEvent() {
        viewPager.setOnPageChangeListener(viewpagerOnPagerChangeListener);
        rgBottomBar.setOnCheckedChangeListener(rgOnCheckChangedListener);
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

    // ********处理夺宝页面  begin***********
    //*********处理夺宝页面  begin***********

    // ********我的页面  begin***********

    private void bindMyPageData() {
//        SimpleAdapter simpleAdapter = new SimpleAdapter
//                (this, getMyPageData(), R.layout.item_grid_my, new String[]{"tabDrawableId", "tabTitle"},
//                        new int[]{R.id.item_grid_my_img, R.id.item_grid_my_tab}) {
//        };
        gridViewAdapter = new GridViewAdapter(MainActivity2Activity.this, getMyPageData());
        myGridView.setAdapter(gridViewAdapter);
    }


    private List<Map<String, Object>> getMyPageData() {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(getMyPageItem("夺宝记录", R.mipmap.ic_reward, 0));
        list.add(getMyPageItem("中奖记录", R.mipmap.ic_record, 1));
        list.add(getMyPageItem("我的晒单", R.mipmap.ic_task_1, 2));
        list.add(getMyPageItem("我的红包", R.mipmap.ic_packet, 3));
        list.add(getMyPageItem("充值记录", R.mipmap.ic_packet, 4));
        list.add(getMyPageItem("帮帮帮", R.mipmap.ic_help, 5));
        list.add(getMyPageItem("常见问题", R.mipmap.ic_help, 6));
        list.add(getMyPageItem("设置", R.mipmap.ic_seting, 7));
        list.add(getMyPageItem("", -1, -1));
        return list;
    }

    private Map<String, Object> getMyPageItem(String tabTitle, Integer tabId, int tabTag) {
        Map<String, Object> tabItem = new HashMap<>();
        tabItem.put("tabDrawableId", tabId);
        tabItem.put("tabTitle", tabTitle);
        tabItem.put("tabTag", tabTag);
        return tabItem;

    }


    //*********我的页面  begin***********

    private void findMyViews() {
    }
//*********我的页面  end***********
}
