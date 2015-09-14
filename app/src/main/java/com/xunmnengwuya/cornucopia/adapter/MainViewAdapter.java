package com.xunmnengwuya.cornucopia.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Candy on 2015/9/14.
 */
public class MainViewAdapter extends PagerAdapter {

    List<View> viewLists;

    public MainViewAdapter(List<View> lists) {
        this.viewLists = lists;

    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position), 0);
        return viewLists.get(position);
    }
}
