package com.example.chenxh.myttestapplication.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenxh.myttestapplication.R;

import java.util.List;

public class RecyclerView1Adapter extends RecyclerView.Adapter<RecyclerView1Adapter.MyViewHolder> {

    private List<String> mData;
    private Context mContext;
    private boolean flag;
    private int mLastPosition;


    public RecyclerView1Adapter(List<String> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_view_item_tv,parent,false);
        final MyViewHolder holder = new MyViewHolder(view);
        Log.e("chenxh","onCreateViewHolder");
        holder.addBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("确认删除吗")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (flag == true){
                                    removeData(holder.getAdapterPosition());
                                    flag=false;
                                }else{
                                    addData(holder.getAdapterPosition());
                                    flag=true;
                                }
                            }
                        }).show();
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv1.setText(mData.get(position));
        Log.e("chenxh","onBindViewHolder"+position);
        holder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        //动画核心
        if (holder.getAdapterPosition() > mLastPosition) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX", 0.5f, 1f);
            scaleX.start();
            mLastPosition = holder.getLayoutPosition();
        }
    }


    /**
     * getItemViewType()
     * 多布局 核心方法  getItemViewType
     * 1、onCreateViewHolder中判断  ==      viewType 进行viewHolder的填充
     * 2、onBindViewHolder中判断 instanceof  viewHolder
     * @param position
     * @return viewType(){Integer}
     */
    @Override
    public int getItemViewType(int position) {

        return 0;

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        Button addBtn,removeBtn;
        TextView tv1;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.recy_view_item_tv1);
            addBtn = (Button) itemView.findViewById(R.id.recy_view_item_btn1);
        }
    }
//    添加数据
    public void addData(int position) {
        mData.add(position,"addData"+position);
        notifyItemInserted(position);
    }
//    删除数据
    public void removeData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

}