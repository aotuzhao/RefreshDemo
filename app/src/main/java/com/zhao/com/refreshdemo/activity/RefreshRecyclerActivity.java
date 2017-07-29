package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.interfaces.IRefreshHeader;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.RecyclerAdapter;
import com.zhao.com.refreshdemo.entity.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshRecyclerActivity extends AppCompatActivity {
    public static RefreshRecyclerActivity refreshRecyclerActivity;
    private LRecyclerView recyclerView;
    private RecyclerAdapter myAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private final static int[] images = {R.drawable.grid_9,
            R.drawable.grid_1,
            R.drawable.grid_2,
            R.drawable.grid_3,
            R.drawable.grid_4,
            R.drawable.grid_6,
            R.drawable.grid_6,
            R.drawable.grid_7,
            R.drawable.grid_8
    };
    public List<Photo> photos=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refreshRecyclerActivity=this;
        setContentView(R.layout.refresh_recycler_view);
        initData();
        recyclerView= (LRecyclerView) findViewById(R.id.recycler_view);
        myAdapter=new RecyclerAdapter(photos);
        lRecyclerViewAdapter=new LRecyclerViewAdapter(myAdapter);

        View header = LayoutInflater.from(this).inflate(R.layout.sample_header,(ViewGroup)findViewById(android.R.id.content), false);

        View footer = LayoutInflater.from(this).inflate(R.layout.sample_footer,(ViewGroup)findViewById(android.R.id.content), false);

        lRecyclerViewAdapter.addHeaderView(header);
        lRecyclerViewAdapter.addFooterView(footer);


        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                myAdapter.notifyDataSetChanged();
                lRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                initData();
                myAdapter.notifyDataSetChanged();
                lRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(lRecyclerViewAdapter);
    }

    private void initData(){

        for (int i=0;i<images.length;i++){
            Photo photo=new Photo(images[i]);
            photos.add(photo);
        }
    }

}
