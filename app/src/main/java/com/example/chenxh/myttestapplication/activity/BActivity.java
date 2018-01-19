package com.example.chenxh.myttestapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chenxh.myttestapplication.R;

public class BActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b_activity_btn:
                sendFinishActivityBroadcast(this);
                break;
        }
    }
    public static void sendFinishActivityBroadcast(Context context) {
        Intent intent = new Intent(BaseActivity.RECEIVER_ACTION_FINISH_A);
        context.sendBroadcast(intent);
        intent = new Intent(BaseActivity.RECEIVER_ACTION_FINISH_B);
        context.sendBroadcast(intent);
    }
}
