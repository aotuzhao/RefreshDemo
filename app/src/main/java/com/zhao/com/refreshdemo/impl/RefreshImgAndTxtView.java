package com.zhao.com.refreshdemo.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.activity.MainActivity;
import com.zhao.com.refreshdemo.util.RefreshLayoutBase;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshImgAndTxtView extends RefreshLayoutBase<LinearLayout>{

    public RefreshImgAndTxtView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshImgAndTxtView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void setupContentView(Context context) {
        mContentView= new LinearLayout(context);

    }

    @Override
    protected boolean isTop() {
        return false;
    }

    @Override
    protected boolean isBottom() {
        return false;
    }
}
