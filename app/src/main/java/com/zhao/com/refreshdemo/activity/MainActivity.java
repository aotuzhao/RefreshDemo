package com.zhao.com.refreshdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhao.com.refreshdemo.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button listButton;
    private Button gridButton;
    private Button imageButton;
    private Button recyclerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.my_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"追逐梦想！",Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(this).load(R.drawable.grid_n1).into(imageView);
        listButton= (Button) findViewById(R.id.refresh_listview);
        gridButton= (Button) findViewById(R.id.refresh_gridview);
        imageButton= (Button) findViewById(R.id.refresh_imageview);
        recyclerButton= (Button) findViewById(R.id.refresh_recyclerview);
        listButton.setOnClickListener(this);
        gridButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.refresh_listview:
                Toast.makeText(MainActivity.this,"ListView",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshListActivity.class));
                break;
            case R.id.refresh_gridview:
                Toast.makeText(MainActivity.this,"GridView",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshGridActivity.class));
                break;
            case R.id.refresh_imageview:
                Toast.makeText(MainActivity.this,"ImageViewAndTextView",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshImgAndTxtActivity.class));
                break;
            case R.id.refresh_recyclerview:
                Toast.makeText(MainActivity.this,"RecyclerView",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshGridActivity.class));
                break;
        }
    }




}
