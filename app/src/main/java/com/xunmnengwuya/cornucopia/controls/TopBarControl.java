package com.xunmnengwuya.cornucopia.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xunmnengwuya.cornucopia.R;
import com.xunmnengwuya.cornucopia.utils.BaseActivity;

/**
 * Created by Candy on 2015/7/31.
 */
public class TopBarControl extends LinearLayout {
    private String topTitle;
    private boolean isBack;
    private Context mContext;
    private TextView txtTitle;
    private LinearLayout llBack;


    public TopBarControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttribute(attrs);
        initContentView();
        initData();
        bindViewEvent();
    }

    private void initAttribute(AttributeSet attrs) {
        TypedArray arrayList = mContext.obtainStyledAttributes(attrs, R.styleable.TopBarControl);
        topTitle = arrayList.getString(R.styleable.TopBarControl_topTitle);
        isBack = arrayList.getBoolean(R.styleable.TopBarControl_isBack, false);
    }

    private void initContentView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.control_top_bar, null);
        txtTitle = (TextView) view.findViewById(R.id.top_bar_txt_title);
        llBack = (LinearLayout) view.findViewById(R.id.top_bar_snatch_back);
        llBack.setVisibility(isBack ? VISIBLE : GONE);
        this.addView(view);
        this.setBackgroundColor(getResources().getColor(R.color.gray_f7));
    }

    private void initData() {
        txtTitle.setText(topTitle);
    }

    private void bindViewEvent() {
        llBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getContext()).finish();
            }
        });
    }
}
