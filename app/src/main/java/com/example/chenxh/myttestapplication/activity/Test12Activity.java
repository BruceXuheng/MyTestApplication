package com.example.chenxh.myttestapplication.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chenxh.myttestapplication.R;
import com.example.chenxh.myttestapplication.adapter.RecyclerView1Adapter;
import com.example.chenxh.myttestapplication.util.MyDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test12Activity extends AppCompatActivity {

    //    initView
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //    initData
    private List<String> dataList = null;
    private RecyclerView1Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);

        initView();

        initData();

        initControl();

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        Log.e("chenxh",bundle.getString("user_name"));

//        String username = intent.getStringExtra("user_name");
//        Log.e("chenxh",username);

    }

    private void initControl() {


//        ListView形式上下滑动：
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

////        左右滑动：
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//
////        Grid形式上下滑动：
//        GridLayoutManager manager = new GridLayoutManager(this,4);
////        Grid形式左右滑动：
//        GridLayoutManager manager = new GridLayoutManager(this, 4);
//        manager.setOrientation(GridLayoutManager.HORIZONTAL);
//
////        瀑布流形式上下滑动：
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
////        瀑布流形式左右滑动：
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(manager);
        adapter = new RecyclerView1Adapter(dataList,this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this, MyDividerItemDecoration.VERTICAL_LIST));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

    }

    private void initData() {

        dataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dataList.add("ifconfig命令用于获取网卡配置与网络状态等信息" + i);
        }

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.recycler_view_swipe);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    if (adapter.isFadeTips() == false && lastVisibleItem + 1 == adapter.getItemCount()) {
//                        mHandler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                updateRecyclerView(adapter.getRealLastPosition(), adapter.getRealLastPosition() + PAGE_COUNT);
//                            }
//                        }, 500);
//                    }
//                    if (adapter.isFadeTips() == true && lastVisibleItem + 2 == adapter.getItemCount()) {
//                        mHandler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                updateRecyclerView(adapter.getRealLastPosition(), adapter.getRealLastPosition() + PAGE_COUNT);
//                            }
//                        }, 500);
//                    }
//                }
//            }
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
//
//            }
//            }
//        });

    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initmData();
                        adapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initmData() {
        dataList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            dataList.add("ifconfig命令用于获取网卡配置与网络状态等信息" + i);
        }
    }

}
