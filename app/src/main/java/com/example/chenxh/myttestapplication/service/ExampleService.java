package com.example.chenxh.myttestapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ExampleService extends Service {

    private static final String TAG = "BindService";

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.i(TAG, "BindService-->onBind()");
        return myBinder;
    }

    public class MyBinder extends Binder {

        public ExampleService getService(){
            Log.i(TAG, "BindService-->getService()");
            return ExampleService.this;
        }
    }
    private MyBinder myBinder = new MyBinder();
    public void MyMethod(){
        Log.i(TAG, "BindService-->MyMethod()");
    }



}
