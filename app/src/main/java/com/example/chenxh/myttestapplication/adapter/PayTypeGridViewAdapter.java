package com.example.chenxh.myttestapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenxh.myttestapplication.R;

import java.util.List;

public class PayTypeGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List mText = null;
    private List mImage = null;

    public PayTypeGridViewAdapter(Context mContext, List mText, List mImage) {
        this.mContext = mContext;
        this.mText = mText;
        this.mImage = mImage;
    }

    @Override
    public int getCount() {
        return mText.size();
    }

    @Override
    public Object getItem(int i) {
        return mText.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PayItemClass payItemClass;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.pop_pay_gridview_item,null);
            TextView tv= (TextView) view.findViewById(R.id.grid_name);
            ImageView img = (ImageView) view.findViewById(R.id.grid_icon);
            payItemClass = new PayItemClass(tv,img);
            view.setTag(payItemClass);
        }else{
            payItemClass = (PayItemClass) view.getTag();
        }
        payItemClass.imageView.setImageResource((Integer) mImage.get(i));
        payItemClass.textView.setText( mText.get(i).toString());
        return view;
    }

    class PayItemClass {
        protected TextView textView;
        protected ImageView imageView;

        public PayItemClass(TextView textView, ImageView imageView) {
            this.textView = textView;
            this.imageView = imageView;
        }
    }

}