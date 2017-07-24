package com.zhao.com.refreshdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhao.com.refreshdemo.R;
import com.zhao.com.refreshdemo.impl.RefreshImgAndTxtView;

import static com.zhao.com.refreshdemo.R.id.image_text_image;
import static com.zhao.com.refreshdemo.R.id.swipe_image_text;

/**
 * Created by zhao on 2017/7/23.
 */

public class RefreshImgAndTxtActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_imgtext_view);
    }

    private void setImgAndTextView(){
        final RefreshImgAndTxtView refreshImgAndTxtView=new RefreshImgAndTxtView(this);
        LinearLayout linearLayout=refreshImgAndTxtView.getContentView();
        imageView= (ImageView) linearLayout.findViewById(R.id.image_text_image);
        textView= (TextView) linearLayout.findViewById(R.id.image_text_text);
        Glide.with(this).load(R.drawable.grid_4).into(imageView);
        textView.setText("下拉刷新的时间");
    }

}
