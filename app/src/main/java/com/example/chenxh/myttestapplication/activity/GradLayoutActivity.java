package com.example.chenxh.myttestapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.adapter.PayTypeGridViewAdapter;
import com.example.chenxh.myttestapplication.util.AnnotateUtils;
import com.example.chenxh.myttestapplication.util.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradLayoutActivity extends AppCompatActivity {

    @ViewInject(R.id.pay_grid_view)
    GridView gridView;

    private List textList = new ArrayList<String>();
    private List imgList = new ArrayList<Integer>();
    private Map<String,Integer> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_layout);
        AnnotateUtils.injectViews(this);
        initData();
        gridView.setAdapter(new PayTypeGridViewAdapter(this,textList,imgList));
    }


    private void initData(){
        for (int i=0;i<10;i++){
            map.put("yinlan",R.mipmap.ic_launcher);
        }





    }


}
