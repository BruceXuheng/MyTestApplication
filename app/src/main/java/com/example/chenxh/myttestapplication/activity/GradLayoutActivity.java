package com.example.chenxh.myttestapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.chenxh.myttestapplication.MainActivity;
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
    private Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_layout);
        AnnotateUtils.injectViews(this);
        initData();
        gridView.setAdapter(new PayTypeGridViewAdapter(this,textList,imgList));
        exitBtn = (Button) findViewById(R.id.grid_btn);
        exitBtn();
    }

    private void exitBtn(){
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });
    }

    private void initData(){
        for (int i=0;i<6;i++){
            map.put("yinlan",R.mipmap.ic_launcher);
        }
    }
    private void exitApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("exit", true);
        startActivity(intent);

        // 结束进程
        // System.exit(0);
    }

}
