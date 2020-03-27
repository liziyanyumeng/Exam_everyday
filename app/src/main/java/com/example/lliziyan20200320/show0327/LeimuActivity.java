package com.example.lliziyan20200320.show0327;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.show0327.adapter.FirstLeimu;
import com.example.lliziyan20200320.show0327.base.BaseActivity1;
import com.example.lliziyan20200320.show0327.bean.LeiBean;
import com.example.lliziyan20200320.show0327.bean.LeiResult;
import com.example.lliziyan20200320.show0327.mvp.LeiContract;
import com.example.lliziyan20200320.show0327.mvp.LeiPresenter;

import java.util.ArrayList;

public class LeimuActivity extends BaseActivity1<LeiPresenter> implements LeiContract.LeiView {

    private androidx.recyclerview.widget.RecyclerView firstRecycler;
    private LinearLayoutManager linearLayoutManager;
    private FirstLeimu firstLeimu;

    @Override
    public int initLayoutId() {
        return R.layout.activity_leimu;
    }

    @Override
    public LeiPresenter initPresenter() {
        return new LeiPresenter();
    }
    @Override
    public void initView() {
        firstRecycler = (RecyclerView) findViewById(R.id.first_recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        firstRecycler.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void initListener() {}
    @Override
    public void initData() {
        p.lei();
    }
    @Override
    public void onSuccessJson(LeiBean leiBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        //适配器
        final ArrayList<LeiResult> result = leiBean.result;
        firstLeimu = new FirstLeimu(LeimuActivity.this,result);
        firstRecycler.setAdapter(firstLeimu);
    }
    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
