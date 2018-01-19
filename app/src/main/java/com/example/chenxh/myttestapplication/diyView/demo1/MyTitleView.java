package com.example.chenxh.myttestapplication.diyView.demo1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.chenxh.myttestapplication.R;

public class MyTitleView extends View{

//    文字 颜色 大小
    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound = new Rect();//范围
    private Paint mPaint = new Paint();;//画笔


    public MyTitleView(Context context) {
        this(context,null);
    }

    public MyTitleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView,defStyleAttr,0);
        int n = array.getIndexCount();
        for (int i = 0 ; i<n;i++){

            int attr = array.getIndex(i);

            switch (attr){
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = array.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTitleTextColor=array.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTitleTextSize = array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }
            array.recycle();

            /**
             * 获得绘制文本的宽和高
             */

            mPaint.setTextSize(mTitleTextSize);
            mPaint.setColor(mTitleTextColor);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        }

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }
    @Override
    protected void onDraw(Canvas canvas) {
//        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
//        mBound = new Rect();
        mPaint.setColor(mTitleTextColor);
        canvas.drawText("123", getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);


    }


}