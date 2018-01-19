package com.example.chenxh.myttestapplication.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class BaseActivity extends Activity {

    //根据需求定义自己需要关闭页面的action
    public static final String RECEIVER_ACTION_FINISH_A = "action_a";
    public static final String RECEIVER_ACTION_FINISH_B = "action_b";

    private FinishActivityRecevier mRecevier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecevier = new FinishActivityRecevier();
        registerFinishReciver();
    }

    private void registerFinishReciver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RECEIVER_ACTION_FINISH_A);
        intentFilter.addAction(RECEIVER_ACTION_FINISH_B);
        registerReceiver(mRecevier, intentFilter);
    }

    private class FinishActivityRecevier extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //根据需求添加自己需要关闭页面的action
            if (RECEIVER_ACTION_FINISH_A.equals(intent.getAction()) ||
                    RECEIVER_ACTION_FINISH_B.equals(intent.getAction()) ) {
                BaseActivity.this.finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mRecevier != null) {
            unregisterReceiver(mRecevier);
        }
        super.onDestroy();
    }
}