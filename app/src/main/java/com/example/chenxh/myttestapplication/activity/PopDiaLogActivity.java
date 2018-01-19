package com.example.chenxh.myttestapplication.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.chenxh.myttestapplication.R;

public class PopDiaLogActivity extends AppCompatActivity {

    PopupWindow mPopWnd = null;
    private Button popBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_dia_log);
        popBtn = (Button) findViewById(R.id.pop_dia_log);
        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("chenxh","dianji");
                showCustomizeDialog();

            }
        });
    }

    private void showCustomizeDialog() {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(this);
        final View dialogView = LayoutInflater.from(this)
                .inflate(R.layout.popu_view,null);
        customizeDialog.setTitle("我是一个自定义Dialog");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
//                        EditText edit_text =
//                                (EditText) dialogView.findViewById(R.id.edit_text);
//                        Toast.makeText(MainActivity.this,
//                                edit_text.getText().toString(),
//                                Toast.LENGTH_SHORT).show();


                    }
                });
        customizeDialog.show();
    }

}
