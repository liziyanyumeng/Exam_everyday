package com.example.lliziyan20200320.Order0402;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.lliziyan20200320.Order0402.adapter.FragmentAdapter;
import com.example.lliziyan20200320.Order0402.base.BaseActivity;
import com.example.lliziyan20200320.Order0402.mvp.OrderPresenter;
import com.example.lliziyan20200320.R;
import com.google.android.material.tabs.TabLayout;

public class OrderActivity extends BaseActivity<OrderPresenter> {

    private com.google.android.material.tabs.TabLayout tablayout;
    private androidx.viewpager.widget.ViewPager viewpager;
    private FragmentAdapter fragmentAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public OrderPresenter initModel() {
        return new OrderPresenter();
    }

    @Override
    public void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void initListener() {}

    @Override
    public void initData() {
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        tablayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(fragmentAdapter);
    }
}
