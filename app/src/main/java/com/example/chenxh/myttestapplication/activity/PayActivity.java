package com.example.chenxh.myttestapplication.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.util.AnnotateUtils;
import com.example.chenxh.myttestapplication.util.ViewInject;

public class PayActivity extends AppCompatActivity {

    @ViewInject(R.id.pay_money)
    EditText money_ed;
    @ViewInject(R.id.pay_method)
    RadioGroup payMethod;
    @ViewInject(R.id.pay_seal)
    Button seal_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        AnnotateUtils.injectViews(this);

        initView();
        seal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PayActivity.this,"测试",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initView() {



    }

}
