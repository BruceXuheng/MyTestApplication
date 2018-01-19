package com.example.chenxh.myttestapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chenxh.myttestapplication.R;

public class AActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.close_btn:
                Intent intent = new Intent(this,BActivity.class);
                startActivity(intent);
                break;

        }

    }
}
