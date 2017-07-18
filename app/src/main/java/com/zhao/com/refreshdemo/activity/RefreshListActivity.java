package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.impl.RefreshListView;
import com.zhao.com.refreshdemo.listener.OnLoadListener;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView的刷新操作
 * Created by zhao on 2017/7/18.
 */

public class RefreshListActivity extends AppCompatActivity {

    final List<String> dataStrings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_list_view);  // 准备数据
        for (int i = 0; i < 20; i++) {
            dataStrings.add("item - " + i);
        }
        setListView();
    }

    private void setListView() {
        final RefreshListView refreshLayout = new RefreshListView(this);

        // 获取ListView, 这里的listview就是Content view
        final ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataStrings);
        refreshLayout.setAdapter(arrayAdapter);
        //设置item点击事件
        refreshLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RefreshListActivity.this,"点击事件",Toast.LENGTH_SHORT).show();
            }
        });
        // 设置下拉刷新监听器
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        for (int i=1;i<3;i++){
                            dataStrings.add("refresh add item - " + i);
                        }
                        arrayAdapter.notifyDataSetChanged();
                        refreshLayout.refreshComplete();
                    }
                }, 1500);
            }
        });

        //设置子项的点击事件


        // 不设置的话到底部不会自动加载
        refreshLayout.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        for (int i=1;i<3;i++){
                            dataStrings.add("load add item - " + i);
                        }
                        arrayAdapter.notifyDataSetChanged();
                        refreshLayout.loadCompelte();
                    }
                }, 1500);
            }
        });

        //
        setContentView(refreshLayout);
    }
}
