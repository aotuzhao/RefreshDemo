package com.zhao.com.refreshdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.impl.RefreshGridView;
import com.zhao.com.refreshdemo.listener.OnLoadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GridView的刷新操作
 * Created by zhao on 2017/7/18.
 */

public class RefreshGridActivity extends AppCompatActivity {

    private final static Integer[] images = {R.drawable.grid_9,
            R.drawable.grid_1,
            R.drawable.grid_2,
            R.drawable.grid_3,
            R.drawable.grid_4,
            R.drawable.grid_6,
            R.drawable.grid_6,
            R.drawable.grid_7,
            R.drawable.grid_8
    };
    private final static Integer[] newImages={
        R.drawable.grid_n1,R.drawable.grid_n2,R.drawable.grid_n3

    };
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_grid_view);

        setGridView();
    }


    private void setGridView() {
        final RefreshGridView gv = new RefreshGridView(this);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String [] from ={"swipe_gridview"};
        int [] to = {R.id.swipe_gridview_image};
        simpleAdapter = new SimpleAdapter(this, data_list, R.layout.grid_list_item, from, to);
        gv.setAdapter(simpleAdapter);

        //刷新
        gv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();
                for (int i=0;i<3;i++){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("swipe_gridview", newImages[i]);
                    data_list.add(map);
                }
                simpleAdapter.notifyDataSetChanged();
                gv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gv.refreshComplete();
                    }
                }, 1500);
            }
        });
        //点击事件
        gv.setOnItemClickListeren(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "mmp", Toast.LENGTH_SHORT).show();
            }
        });
        // 不设置的话到底部不会自动加载
        gv.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                for (int i=0;i<=1;i++){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("swipe_gridview", newImages[i]);
                    data_list.add(map);
                }
                simpleAdapter.notifyDataSetChanged();

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


    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("swipe_gridview", images[i]);

            data_list.add(map);
        }

        return data_list;
    }


}

