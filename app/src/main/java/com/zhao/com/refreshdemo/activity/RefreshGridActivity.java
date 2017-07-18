package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.impl.RefreshGridView;
import com.zhao.com.refreshdemo.listener.OnLoadListener;

/**
 * GridView的刷新操作
 * Created by zhao on 2017/7/18.
 */

public class RefreshGridActivity extends AppCompatActivity {

    private final static int[] images={R.drawable.grid_9,
            R.drawable.grid_1,
            R.drawable.grid_2,
            R.drawable.grid_3,
            R.drawable.grid_4,
            R.drawable.grid_6,
            R.drawable.grid_6,
            R.drawable.grid_7,
            R.drawable.grid_8,
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.refresh_grid_view);
    }

    private void setGridView(){
        final RefreshGridView gv = new RefreshGridView(this);



        gv.setAdapter(null);



        //
        gv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();

                gv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gv.refreshComplete();
                    }
                }, 1500);
            }
        });

        // 不设置的话到底部不会自动加载
        gv.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                gv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gv.loadCompelte();
                    }
                }, 1500);
            }
        });

        setContentView(gv);
    }
}
