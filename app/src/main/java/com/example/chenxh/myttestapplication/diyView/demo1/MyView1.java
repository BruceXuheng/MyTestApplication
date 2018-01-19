package com.example.chenxh.myttestapplication.diyView.demo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MyView1 extends View {
    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//  测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(200, 200);
//        childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);
//        childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);

    }

}