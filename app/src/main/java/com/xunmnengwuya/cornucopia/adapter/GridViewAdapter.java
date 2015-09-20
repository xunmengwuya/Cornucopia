package com.xunmnengwuya.cornucopia.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xunmnengwuya.cornucopia.R;
import com.xunmnengwuya.cornucopia.utils.ConvertUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Candy on 2015/9/20.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<Map<String, Object>> mList;
    private Context mContext;

    int width = 0;
    int height = 0;

    public GridViewAdapter(Context context, List<Map<String, Object>> list) {
        mList = list;
        mContext = context;
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels / 3 - 2;
        height = (displayMetrics.heightPixels - 48 - getStatusBarHeight()) / 5 - 12;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public int getCount() {
        if (null == mList) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Map<String, Object> getItem(int position) {
        if (null == mList) {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_my, null);
            convertView.setLayoutParams(new GridView.LayoutParams(width, height));//
        }
        Map<String, Object> item = mList.get(position);

        TextView txtTab = (TextView) convertView.findViewById(R.id.item_grid_my_tab);
        ImageView image = (ImageView) convertView.findViewById(R.id.item_grid_my_img);
        String tag = ConvertUtils.getString(item.get("tabTag"), "-1");
        if (!tag.equals("-1")) {
            image.setImageResource(ConvertUtils.getInteger(item.get("tabDrawableId")));
            txtTab.setText(ConvertUtils.getString(item.get("tabTitle"), ""));
            txtTab.setTag(tag);
        }
        return convertView;
    }

}
