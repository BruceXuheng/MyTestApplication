package com.example.chenxh.myttestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.activity.AActivity;
import com.example.chenxh.myttestapplication.activity.AnimationActivity;
import com.example.chenxh.myttestapplication.activity.BitmapIOActivity;
import com.example.chenxh.myttestapplication.activity.GradLayoutActivity;
import com.example.chenxh.myttestapplication.activity.PayActivity;
import com.example.chenxh.myttestapplication.activity.PopDiaLogActivity;
import com.example.chenxh.myttestapplication.activity.PrintActivity;
import com.example.chenxh.myttestapplication.activity.SPActivity;
import com.example.chenxh.myttestapplication.activity.SecondActivity;
import com.example.chenxh.myttestapplication.activity.ServiceActivity;
import com.example.chenxh.myttestapplication.activity.Test12Activity;
import com.example.chenxh.myttestapplication.activity.TwoActivity;
import com.example.chenxh.myttestapplication.activity.WifiActivity;
import com.example.chenxh.myttestapplication.diyView.demo1.DiyViewActivity;
import com.socsi.SoSDKManager;
import com.ums.MasterInterfaceHelper;
import com.ums.UpdateListener;

public class MainActivity extends AppCompatActivity {

    Button btn7;
    int updateSucess;
    private SoSDKManager soSDKManager;
    private String vendor="12";
    private String TAG = "testMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn7 = (Button) findViewById(R.id.btn7);

        if ("VERIFONE".equalsIgnoreCase(vendor)||"惠尔丰".equals(vendor)) {
            try {
                soSDKManager = (SoSDKManager) this.getSystemService("SoSDKService");
                soSDKManager.setKeyHomeState(true);
                boolean temp = soSDKManager.getKeyHomeState();
                Log.i("info", "onCreate Hom : " + temp);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if ("VERIFONE".equalsIgnoreCase(vendor)||"惠尔丰".equals(vendor)) {
//            try {
//                boolean temp = soSDKManager.getKeyHomeState();
//                Log.i("info", "onResume Hom 1: " + temp);
//                if (temp == false){
//                    Log.e("info","onResume Hom经过");
//                    soSDKManager.setKeyHomeState(true);
//                }
//                temp = soSDKManager.getKeyHomeState();
//                Log.i("info", "onResume Hom 2: " + temp);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void onClick(View view) {

        Intent intent = new Intent();
        switch (view.getId()) {

            case R.id.btn1:
                intent.setClass(this, TwoActivity.class);
                startActivity(intent);
                break;
//            测试数据库
            case R.id.btn2:
                intent.setClass(this, SecondActivity.class);
                startActivity(intent);
                break;
//            交易
            case R.id.btn3:
                intent.setClass(this, PayActivity.class);
                startActivity(intent);
                break;

//            查看交易
            case R.id.btn4:

                break;
//            撤销
            case R.id.btn5:

                break;
            case R.id.btn6:
                intent = intent.setClass(this, DiyViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn7:
//              更新环境测试
                MasterInterfaceHelper helper = new MasterInterfaceHelper();
                helper.update(MainActivity.this, new UpdateListener() {
                    @Override
                    public void onState(final int i, final String s) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btn7.setText(i + "--" + s);
                            }
                        });
                    }
                });

                if (updateSucess == 4)

//                MasterInterfaceHelper.update(this, UpdateListener l);


                break;
//           测试Sp
            case R.id.btn8:
                intent = intent.setClass(this, SPActivity.class);
                startActivity(intent);
                break;
//          测试服务
            case R.id.btn9:
                intent = intent.setClass(this, ServiceActivity.class);
                startActivity(intent);
                break;
//            自定义弹窗
            case R.id.btn10:
                intent = intent.setClass(this, PopDiaLogActivity.class);
                startActivity(intent);
                break;
//            打印测试
            case R.id.btn11:
                intent = intent.setClass(this, PrintActivity.class);
                startActivity(intent);
                break;
            case R.id.close_home:
                homeForbidden();
                break;
            case R.id.open_home:
                homeRelease();
                break;
            case R.id.get_home:
                getHomeStatus();
                break;
            case R.id.btn12:
                intent = intent.setClass(this, Test12Activity.class);
//                Bundle bundle=new Bundle();
//                bundle.putString("user_name","chenxh");
//                intent.putExtras(bundle);
//                intent.putExtra("user_name","chenxh");
                startActivity(intent);
                break;
            case R.id.btn13:
                intent = intent.setClass(this, AActivity.class);
                startActivity(intent);
                break;
            case R.id.btn14:
                intent = intent.setClass(this, AActivity.class);
                startActivity(intent);
                break;
            case R.id.btn15:
                intent = intent.setClass(this,GradLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn16:
                intent = intent.setClass(this,AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn17://隔空取物  烂尾
                intent = intent.setClass(this,WifiActivity.class);
                startActivity(intent);
                break;
            case R.id.btn18://Bitmap 复习流知识  持续。。。
                intent = intent.setClass(this,BitmapIOActivity.class);
                startActivity(intent);
                break;
        }

    }

    //退出时的时间
    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //退出方法
    private void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
        //用户退出处理
            finish();
            System.exit(0);
        }
    }

    private void homeForbidden(){
        if(soSDKManager == null){
            soSDKManager = (SoSDKManager)this.getSystemService("SoSDKService");
        }

        try {
            soSDKManager.setKeyHomeState(true);
            if(soSDKManager.getKeyHomeState()){
                Toast.makeText(this, "home键已被禁用", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "homeForbidden: home键已被禁用");
            }else{
                Toast.makeText(this, "home键禁用失败", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "homeForbidden: home键禁用失败");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "homeForbidden: 抛出异常");
        }

    }

    private void homeRelease(){
        if(soSDKManager == null){
            soSDKManager = (SoSDKManager)this.getSystemService("SoSDKService");
        }
        try {
            soSDKManager.setKeyHomeState(false);
            if(soSDKManager.getKeyHomeState()){
                Toast.makeText(this, "home键恢复失败", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "homeForbidden: 放开home键失败");
            }else{
                Toast.makeText(this, "home键恢复", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "homeForbidden: 放开home键");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "homeForbidden: 抛出异常");
        }
    }

    private void getHomeStatus(){
        if(soSDKManager == null){
            soSDKManager = (SoSDKManager)this.getSystemService("SoSDKService");
        }

        try {
            boolean homeStatus = soSDKManager.getKeyHomeState();
            if(homeStatus){
                Toast.makeText(this, "home禁用",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "getHomeStatus: "+ homeStatus);
            }else{
                Toast.makeText(this, "home键放开", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "getHomeStatus: " + homeStatus);
            }
        } catch (RemoteException e) {
            Log.d(TAG, "getHomeStatus: 获取状态抛出异常");
            e.printStackTrace();
        }

    }


}
