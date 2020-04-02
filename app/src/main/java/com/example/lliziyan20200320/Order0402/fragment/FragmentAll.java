package com.example.lliziyan20200320.Order0402.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.Order0402.adapter.AllAdapter;
import com.example.lliziyan20200320.Order0402.base.BaseFragment;
import com.example.lliziyan20200320.Order0402.bean.OrderListBean;
import com.example.lliziyan20200320.Order0402.bean.OrderShow;
import com.example.lliziyan20200320.Order0402.mvp.OrderContract;
import com.example.lliziyan20200320.Order0402.mvp.OrderPresenter;
import com.example.lliziyan20200320.R;

import java.util.ArrayList;
//使用fragment复用
public class FragmentAll extends BaseFragment<OrderPresenter> implements OrderContract.OrderView {
    private RecyclerView recyclerOrder;
    private ArrayList<OrderListBean> orderList;
    private int orderStatus;

    @Override
    public int initLayoutId() {
        return R.layout.fragmentall;
    }

    @Override
    public OrderPresenter initModel() {
        return new OrderPresenter();
    }

    public static FragmentAll newInstance(int status) {
        Bundle args = new Bundle();
        args.putInt("status",status);
        FragmentAll fragment = new FragmentAll();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View inflate) {
        recyclerOrder = (RecyclerView) inflate.findViewById(R.id.recycler_order);
        //设置布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerOrder.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        final Bundle arguments = getArguments();
        f.ordershow(1,10,arguments.getInt("status"));
//        if (orderStatus == 0){
//            f.ordershow(1,10,0);
//        }else if (orderStatus == 1){
//            f.ordershow(1,10,1);
//        }else if (orderStatus == 2){
//            f.ordershow(1,10,2);
//        }else if (orderStatus == 3){
//            f.ordershow(1,10,3);
//        }else if (orderStatus == 9){
//            f.ordershow(1,10,9);
//        }
        f.ordershow(1,10,0);
    }

    @Override
    public void onSuccessJson(OrderShow orderShow) {
        final ArrayList<OrderListBean> orderList = orderShow.orderList;
        final AllAdapter allAdapter = new AllAdapter(getContext(),orderList);
        recyclerOrder.setAdapter(allAdapter);
        for (int i = 0; i < orderList.size(); i++){
            orderStatus = orderList.get(i).orderStatus;
        }
    }

    @Override
    public void onFailureJson(String msg) {

    }
}
