package com.example.chenxh.myttestapplication.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.MainActivity;
import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.service.ExampleService;

public class ServiceActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unbindService).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                Toast.makeText(this, "开启服务", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ServiceActivity.this, ExampleService.class);

                startService(intent);

                break;
            case R.id.stopService:
                Toast.makeText(this, "关闭服务", Toast.LENGTH_SHORT).show();
                Intent stopIntent = new Intent(ServiceActivity.this, ExampleService.class);

                stopService(stopIntent);

                break;
            case R.id.bindService:
                bindService();
                break;
            case R.id.unbindService:
                unBind();
                break;


        }
    }

    private void bindService(){
        Intent intent = new Intent(this,ExampleService.class);
        bindService(intent,conn, Context.BIND_AUTO_CREATE);

    }
    private void unBind(){
        if(flag==true){
            unbindService(conn);
            Log.v("BindService","unBInd()");
            flag = false;
        }
    }

    private boolean flag;
    private ServiceConnection conn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ExampleService.MyBinder binder = (ExampleService.MyBinder) iBinder;
            ExampleService exampleService = binder.getService();
            exampleService.MyMethod();
            flag = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };


}
