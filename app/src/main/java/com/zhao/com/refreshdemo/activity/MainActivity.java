package com.zhao.com.refreshdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhao.com.refreshdemo.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button listButton;
    private Button gridButton;
    private Button imageButton;
    private Button recyclerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Toast.makeText(MainActivity.this,"List刷新",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshListActivity.class));
                break;
            case R.id.refresh_gridview:
                Toast.makeText(MainActivity.this,"Grid刷新",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RefreshGridActivity.class));
                break;
        }
    }




}
