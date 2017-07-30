package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.adapter.HeaderAndFooterWrapper;
import com.zhao.com.refreshdemo.adapter.RecyclerAdapter;
import com.zhao.com.refreshdemo.entity.Photo;
import com.zhao.com.refreshdemo.listener.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshRecyclerActivity extends AppCompatActivity {
    public static RefreshRecyclerActivity refreshRecyclerActivity;
    private RecyclerView recyclerView;
    private RecyclerAdapter myAdapter;
    private HeaderAndFooterWrapper headerAndFooterWrapper;
    private final static int[] images = {R.drawable.grid_9,
            R.drawable.grid_1,
            R.drawable.grid_2,
            R.drawable.grid_3,
            R.drawable.grid_4,
            R.drawable.grid_6,
            R.drawable.grid_6,
            R.drawable.grid_7,
            R.drawable.grid_1,
            R.drawable.grid_2,
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
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        myAdapter=new RecyclerAdapter(photos);

        headerAndFooterWrapper=new HeaderAndFooterWrapper(myAdapter);

        View header=View.inflate(this,R.layout.recycler_header,null);
        View footer=View.inflate(this,R.layout.recycler_footer,null);
        headerAndFooterWrapper.addHeaderView(header);
        headerAndFooterWrapper.addFootView(footer);

        recyclerView.setAdapter(headerAndFooterWrapper);

       recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
           @Override
           public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
               if (!recyclerView.canScrollVertically(1)){
                   Toast.makeText(RefreshRecyclerActivity.refreshRecyclerActivity,"上拉加载",Toast.LENGTH_SHORT).show();
                   initData();
                   headerAndFooterWrapper.notifyDataSetChanged();
               }
               if(recyclerView.canScrollVertically(-1)==false){
                   Toast.makeText(RefreshRecyclerActivity.refreshRecyclerActivity,"下拉刷新",Toast.LENGTH_SHORT).show();
                   initData();
                   headerAndFooterWrapper.notifyDataSetChanged();
               }
           }

       });

    }

    private void initData(){
        if (photos.size()==0){
            for (int i=0;i<images.length;i++){
                Photo photo=new Photo(images[i]);
                photos.add(photo);
            }
        }else{
            for (int i=0;i<3;i++){
                Photo photo=new Photo(images[i]);
                photos.add(photo);
            }
        }

    }

}
