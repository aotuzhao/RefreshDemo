package com.zhao.com.refreshdemo.impl;

import android.content.Context;
import android.util.AttributeSet;

import android.widget.LinearLayout;

import com.zhao.com.refreshdemo.util.RefreshLayoutBase;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshImgAndTxtView extends RefreshLayoutBase<LinearLayout>{
    public RefreshImgAndTxtView(Context context) {
        super(context);
    }
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

    public  void setOnClickListener(OnClickListener onClickListener){
        mContentView.setOnClickListener(onClickListener);
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
