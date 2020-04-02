package com.example.lliziyan20200320.Order0402.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//activity的父类
public abstract class BaseActivity<p extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    private int i;
    public p p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = initLayoutId();
        setContentView(i);
        p = initModel();
        if (p!=null) {
            p.attachView(this);
        }
        initView();
        initListener();
        initData();
    }
    public abstract int initLayoutId();
    public abstract p initModel();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null) {
            p.detachView();
        }
    }
}
