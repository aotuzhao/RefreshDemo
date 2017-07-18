package com.zhao.com.refreshdemo.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.zhao.com.refreshdemo.util.RefreshAdaterView;
import com.zhao.com.refreshdemo.util.RefreshLayoutBase;

/**
 * 自定义的GridView刷新控件，实现RefreshLayoutBase类
 * Created by zhao on 2017/7/18.
 */

public class RefreshGridView extends RefreshAdaterView<GridView> {
    public RefreshGridView(Context context) {
        super(context);
    }

    public RefreshGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    //设置主要的布局
    @Override
    protected void setupContentView(Context context) {
        mContentView=new GridView(context);
        mContentView.setNumColumns(3);
        mContentView.setHorizontalSpacing(8);
        mContentView.setVerticalSpacing(8);
        //设置监听
        mContentView.setOnScrollListener(this);

    }

    @Override
    protected boolean isTop() {
        return mContentView.getFirstVisiblePosition() == 0
                && getScrollY() <= mHeaderView.getMeasuredHeight();
    }

    @Override
    protected boolean isBottom() {
        return mContentView != null && mContentView.getAdapter() != null
                && mContentView.getLastVisiblePosition() ==
                mContentView.getAdapter().getCount() - 1 && mYOffset < 0;
    }
}
