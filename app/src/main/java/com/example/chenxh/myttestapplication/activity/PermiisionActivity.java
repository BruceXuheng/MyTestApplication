package com.example.chenxh.myttestapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chenxh.myttestapplication.R;

public class PermiisionActivity extends AppCompatActivity {

    private static final String TAG = "chenxh";
    private Object image;
    private boolean fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permiision);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.camera_permission_btn:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {//判断该应用中是否有该权限
                    //需要授权的 那些
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            100);
                } else {
                    getImage();
                }
                break;
        }

    }


    public Object getImage() {
        // 利用系统自带的相机应用:拍照
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // create a file to save the image
//        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
//
//        // 此处这句intent的值设置关系到后面的onActivityResult中会进入那个分支，即关系到data是否为null，如果此处指定，则后来的data为null
//        // set the image file name
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//
//        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        return image;
    }
}
