package com.zhao.com.refreshdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.activity.RefreshRecyclerActivity;
import com.zhao.com.refreshdemo.entity.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/7/29.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private List<Photo> photos=new ArrayList<>();

    public RecyclerAdapter(List<Photo> photoList){
        photos=photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo=photos.get(position);
        Glide.with(RefreshRecyclerActivity.refreshRecyclerActivity).load(photo.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.recycler_item_image);

        }
    }
}
