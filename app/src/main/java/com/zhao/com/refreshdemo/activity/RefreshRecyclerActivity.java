package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhao.com.refreshdemo.R;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshRecyclerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_recycler_view);
    }
}
