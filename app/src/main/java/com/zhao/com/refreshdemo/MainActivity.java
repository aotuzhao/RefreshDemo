package com.zhao.com.refreshdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.zhao.com.refreshdemo.impl.RefreshListView;
import com.zhao.com.refreshdemo.listener.OnLoadListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    final List<String> dataStrings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 准备数据
        for (int i = 0; i < 20; i++) {
            dataStrings.add("item - " + i);
        }
        setListView();
    }

    private void setListView() {
        final RefreshListView refreshLayout = new RefreshListView(this);

        // 获取ListView, 这里的listview就是Content view
        refreshLayout.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataStrings));
        // 设置下拉刷新监听器
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshLayout.refreshComplete();
                    }
                }, 1500);
            }
        });

        // 不设置的话到底部不会自动加载
        refreshLayout.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshLayout.loadCompelte();
                    }
                }, 1500);
            }
        });

        //
        setContentView(refreshLayout);
    }

}
