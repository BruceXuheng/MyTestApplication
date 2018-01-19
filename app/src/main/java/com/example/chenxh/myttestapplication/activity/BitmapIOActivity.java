package com.example.chenxh.myttestapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.R;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BitmapIOActivity extends AppCompatActivity {

    private Button createFileBtn;//创建文件夹

    private ImageView image;
    private Bitmap bit;


    private static final String SAVE_PIC_PATH=Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED)
            ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/mnt/sdcard/chenxh/mytestApp";//保存到SD卡
    private static final String SAVE_REAL_PATH = SAVE_PIC_PATH+  "/res/chenchen";//保存确切位置

    String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/chenxh/myTestApplication/img";
    private Bitmap mBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_io);
        image = (ImageView) findViewById(R.id.after_img);

        createFileBtn = (Button) findViewById(R.id.create_file);
        createFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFolder();
//                    Bitmap bitmap1 = imgToBitmap();
//                    saveImage(getScaleBitmap( BitmapBytes(bitmap1),4),"chen12345678.jpeg","/testImage");
                xxFileWriteData();

            }
        });


    }
// 续写本地文件内容

    private void xxFileWriteData(){
        File file = new File(SAVE_REAL_PATH, "log.txt");
        RandomAccessFile raf = null;
        try {
            //如果为追加则在原来的基础上继续写文件
            raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write("sadasdasdas".getBytes());
            raf.write("\n".getBytes());
        } catch (IOException e) {

        }
    }


// 创建文件 写入文件内容
    private void crFilewriteData(){
        File saveFile = new File(SAVE_REAL_PATH, "log.txt");
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(saveFile);
            outStream.write("json数据".getBytes());
            outStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    /**
     * 二次采样
     * 思路步骤：
     * 1、获取图片边缘
     * 2、解锁边缘锁
     * 3、获取压缩比
     * 4、长宽压缩比进行像素压缩
     * 5、选取图片质量格式  （格式种类 ： 1、） compress
     * 6、锁边 return Bitmap
     *
     *
     */
//
    public Bitmap getScaleBitmap(byte[] data,int size)
    {
        //1, 得到用来设置图片的属性参数对象
        BitmapFactory.Options options = new BitmapFactory.Options();

        //2, 解码边缘
        options.inJustDecodeBounds = true;

        //3, 进行图片解码
        BitmapFactory.decodeByteArray(data, 0, data.length, options);


        //4, 设置缩放的比例, 只能设置大于1的, 数值越多, 缩放的比例就越小
        //压缩成2的多少次幂   2 -- > 2,3 ; 大于4 小于8 都按4来压缩
        options.inSampleSize = size;

        //5, 将图片的质量设置为RGB_565
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        //6,锁住图片边缘
        options.inJustDecodeBounds = false;

        //7, 通过参数对象, 获取新的图片
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);

        return bitmap;


    }

    public static byte[] BitmapBytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    //保存图片到本地路径
    public static void saveImage(Bitmap bm, String fileName, String path) throws IOException {
        String subForder = SAVE_REAL_PATH + path;
        File foder = new File(subForder);
        if (!foder.exists()) {
            foder.mkdirs();
        }
        File myCaptureFile = new File(subForder, fileName);
        if (!myCaptureFile.exists()) {
            myCaptureFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }
    //创建文件夹
    private void createFolder() {
        //新建一个File，传入文件夹目录
        File file = new File(SAVE_REAL_PATH);
        //判断文件夹是否存在，如果不存在就创建，否则不创建
        if (!file.exists()) {
            //通过file的mkdirs()方法创建目录中包含却不存在的文件夹
            file.mkdirs();
        }
    }

    //创建文件
    private void createFile(){
        //传入路径 + 文件名
        File mFile = new File(SAVE_REAL_PATH+"/log.txt");
        //判断文件是否存在，存在就删除
        if (mFile.exists()){
            mFile.delete();
        }
        try {
            //创建文件
            mFile.createNewFile();
            //给一个吐司提示，提示创建成功
            Toast.makeText(getApplicationContext(), "文件创建成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private boolean getState(){
//        //获取内部存储状态
//        String state = Environment.getExternalStorageState();
//        //如果状态不是mounted，无法读写
//        if (!state.equals(Environment.MEDIA_MOUNTED)) {
//            return false;
//        }
//        return true;
//    }
//
//    返回项目中图片 bitmap
    private Bitmap imgToBitmap(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(SAVE_REAL_PATH+"testImage/chen.jpeg");
        } catch (FileNotFoundException e) {

        }
        Bitmap bitmap  = BitmapFactory.decodeStream(fis);
        return bitmap;
    }

//
//    private void saveBitmap(){
//        try {
//            File file = new File(dir + "imgbitmapio" + ".jpg");
//            FileOutputStream out = new FileOutputStream(file);
//            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static void saveFile(Bitmap bm, String fileName, String path) throws IOException {
//        String subForder = SAVE_REAL_PATH + path;
//        File foder = new File(subForder);
//        if (!foder.exists()) {
//            foder.mkdirs();
//        }
//        File myCaptureFile = new File(subForder, fileName);
//        if (!myCaptureFile.exists()) {
//            myCaptureFile.createNewFile();
//        }
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
//        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
//        bos.flush();
//        bos.close();
//    }

}
