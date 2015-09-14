package com.xunmnengwuya.cornucopia;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.xunmnengwuya.cornucopia.utils.ActivityManager;
import com.xunmnengwuya.cornucopia.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    private ListView leftListView;
    private FrameLayout contentFrame;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this, R.layout.activity_main);
        findViews();
        initListView();
    }

    private void findViews() {
        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
        leftListView = (ListView) findViewById(R.id.left_list_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    private void initListView() {


        // Set the adapter for the list view
        leftListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getList()));
        // Set the list's click listener
//        leftListView.setOnItemClickListener(new OnItemClickListener()
//        {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id)
//            {
//                // Highlight the selected item, update the title, and close the
//                // drawer
//                mDrawerList.setItemChecked(position, true);
//                setTitle(mPlanetTitles[position]);
//                mDrawerLayout.closeDrawer(mDrawerList);
//            }
//        });
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("selection" + i);

        }
        return list;

    }
}
