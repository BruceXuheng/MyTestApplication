package com.example.chenxh.myttestapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chenxh.myttestapplication.R;
import com.ums.upos.sdk.exception.CallServiceException;
import com.ums.upos.sdk.exception.SdkException;
import com.ums.upos.sdk.printer.BoldEnum;
import com.ums.upos.sdk.printer.FontConfig;
import com.ums.upos.sdk.printer.FontSizeEnum;
import com.ums.upos.sdk.printer.OnPrintResultListener;
import com.ums.upos.sdk.printer.PrinterManager;
import com.ums.upos.sdk.system.BaseSystemManager;
import com.ums.upos.sdk.system.OnServiceStatusListener;


public class PrintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
    }



    private void initMethod() {
        String printHtmlstr = "<h1>123</h1><p>ppp</p>";
        try {
            PrinterManager printer = new PrinterManager();
            printer.initPrinter();
            FontConfig fontConfig = new FontConfig();
            fontConfig.setBold(BoldEnum.NOT_BOLD);//���Ӵ�
            fontConfig.setSize(FontSizeEnum.SMALL);//С������
            printer.setPrnText(printHtmlstr, fontConfig);
            printer.startPrint(new OnPrintResultListener() {

                @Override
                public void onPrintResult(int arg0) {//arg0�ɼ�ServiceResult.java
                    //�ǳ�������ռ��U�ܹ�����
                    try {
                        BaseSystemManager.getInstance().deviceServiceLogout();
                    } catch (SdkException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
//                    btn_printer.setVisibility(View.GONE);
                }
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void onClick(View view) {

        switch (view.getId()){
            case R.id.print_login:
                try {
                    BaseSystemManager.getInstance().deviceServiceLogin(
                            this, null, "99999998",//�豸ID�������Һ�̨����
                            new OnServiceStatusListener() {
                                @Override
                                public void onStatus(int arg0) {//arg0�ɼ�ServiceResult.java
                                    Log.e("chenxh",arg0+"-----");
                                    if (0 == arg0 || 2 == arg0 || 100 == arg0) {//0����¼�ɹ�������ز�����2����¼�ɹ�������ز�����100���ظ���¼��
//                                        btn_printer.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                } catch (SdkException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case R.id.print1:
                initMethod();
                break;
        }

    }
}
