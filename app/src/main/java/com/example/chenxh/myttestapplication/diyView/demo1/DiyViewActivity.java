package com.example.chenxh.myttestapplication.diyView.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.util.AnnotateUtils;
import com.example.chenxh.myttestapplication.util.ViewInject;

public class DiyViewActivity extends AppCompatActivity {

    @ViewInject(R.id.diy_view_activity_linearlyt)
    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_view);

        AnnotateUtils.injectViews(this);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View buttonLayout = layoutInflater.inflate(R.layout.diy1_button_layout,null);
        mainLayout.addView(buttonLayout);

        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DiyViewActivity.this,"自定义Button",Toast.LENGTH_LONG).show();
            }
        });

    }
}
