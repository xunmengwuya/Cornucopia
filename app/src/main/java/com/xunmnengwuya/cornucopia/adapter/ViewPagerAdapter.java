package com.xunmnengwuya.cornucopia.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Candy on 2015/9/16.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ImageView> mImgUrls;

    public ViewPagerAdapter(Context context, List<ImageView> imgUrls) {
        mContext = context;
        mImgUrls = imgUrls;
    }

    @Override
    public int getCount() {
        return mImgUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImgUrls.get(position % mImgUrls.size()));
        return mImgUrls.get(position % mImgUrls.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImgUrls.get(position % mImgUrls.size()));
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
