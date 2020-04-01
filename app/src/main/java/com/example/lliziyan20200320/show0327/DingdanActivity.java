package com.example.lliziyan20200320.show0327;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.show0327.base.BaseActivity1;
import com.example.lliziyan20200320.show0327.bean.AddressBean;
import com.example.lliziyan20200320.show0327.bean.AddressResult;
import com.example.lliziyan20200320.show0327.mvp.AddAddressContract;
import com.example.lliziyan20200320.show0327.mvp.AddAddressPresenter;

import java.util.ArrayList;

public class DingdanActivity extends BaseActivity1<AddAddressPresenter> implements AddAddressContract.AddAddressView {

    private TextView textDizhi;
    private String realName;
    private String phone;
    private String address;
    private android.widget.Button btnCommit;

    @Override
    public int initLayoutId() {
        return R.layout.activity_dingdan;
    }

    @Override
    public AddAddressPresenter initPresenter() {
        return new AddAddressPresenter();
    }

    @Override
    public void initView() {
        textDizhi = (TextView) findViewById(R.id.text_dizhi);
        btnCommit = (Button) findViewById(R.id.btn_commit);
    }

    @Override
    public void initListener() {
        textDizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.address();
                textDizhi.setText(realName);
            }
        });
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(DingdanActivity.this,CreateActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void initData() {
    }

    @Override
    public void onSuccessJson(AddressBean addressBean) {
        final ArrayList<AddressResult> result = addressBean.result;
        for (int i = 0; i < result.size(); i++){
            realName = result.get(0).realName;
            phone = result.get(0).phone;
            address = result.get(0).address;
        }
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
