package com.example.lliziyan20200320.show0327;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.show0327.base.BaseActivity1;
import com.example.lliziyan20200320.show0327.bean.OrderBean;
import com.example.lliziyan20200320.show0327.mvp.OrderContract;
import com.example.lliziyan20200320.show0327.mvp.orderpresenter;

public class CreateActivity extends BaseActivity1<orderpresenter> implements OrderContract.OrderView {

    private android.widget.TextView textOrderInfo;
    private android.widget.TextView textTotalPrice;
    private android.widget.TextView textAddressId;

    @Override
    public int initLayoutId() {
        return R.layout.activity_create;
    }

    @Override
    public orderpresenter initPresenter() {
        return new orderpresenter();
    }

    @Override
    public void initView() {
        textOrderInfo = (TextView) findViewById(R.id.text_orderInfo);
        textTotalPrice = (TextView) findViewById(R.id.text_totalPrice);
        textAddressId = (TextView) findViewById(R.id.text_addressId);
    }

    @Override
    public void initListener() {}

    @Override
    public void initData() {
        p.order("[{\"commodityId\":5,\"amount\":1}]",39,3473);
    }

    @Override
    public void onSuccessJson(OrderBean orderBean) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, "提交失败", Toast.LENGTH_SHORT).show();
    }
}
