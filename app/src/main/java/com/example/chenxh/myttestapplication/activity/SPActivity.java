package com.example.chenxh.myttestapplication.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chenxh.myttestapplication.R;

public class SPActivity extends AppCompatActivity {

    TextView user, pub,test_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        initView();
        setSP();
        getSP();

    }

    private void setSP() {
        SharedPreferences mySharedPreferences = getSharedPreferences("user",
                MODE_PRIVATE);
        //实例化SharedPreferences.Editor对象
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        //用putString的方法保存数据
        editor.putString("name", "admin");
        editor.putString("password", "123");
        //提交当前数据
        editor.apply();
        SharedPreferences ppreferences = getSharedPreferences("public",
                MODE_PRIVATE);
        //实例化SharedPreferences.Editor对象
        SharedPreferences.Editor peditor = ppreferences.edit();
        //用putString的方法保存数据
        peditor.putString("name", "ppppp");
        peditor.putString("password", "ppp123");
        //提交当前数据
        peditor.apply();
    }

    private void initView() {
        user = (TextView) findViewById(R.id.tv_user);
        pub = (TextView) findViewById(R.id.tv_public);
        test_context = (TextView) findViewById(R.id.sp_context);
        char[] charArray = "101000000000".toCharArray();
        test_context.setText(String.valueOf(charArray[0]));

    }

    private void  getSP() {
        //同样，在读取SharedPreferences数据前要实例化出一个SharedPreferences对象
        SharedPreferences sharedPreferences= getSharedPreferences("user",
                Activity.MODE_PRIVATE);
        // 使用getString方法获得value，注意第2个参数是value的默认值
        String name =sharedPreferences.getString("name", "");
        String password =sharedPreferences.getString("password", "");
        user.setText(name+","+password);
        //同样，在读取SharedPreferences数据前要实例化出一个SharedPreferences对象
        SharedPreferences psharedPreferences= getSharedPreferences("public",
                Activity.MODE_PRIVATE);
        // 使用getString方法获得value，注意第2个参数是value的默认值
        String pname =psharedPreferences.getString("name", "");
        String ppassword =psharedPreferences.getString("password", "");
        pub.setText(pname+","+ppassword);

//        editor.putBoolean("sysPriNet", getSharedPreferences("system", MODE_PRIVATE).getBoolean("sysPriNet", false));
    }

}
