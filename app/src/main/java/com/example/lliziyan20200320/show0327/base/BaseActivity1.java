package com.example.lliziyan20200320.show0327.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity1<p extends IBasePresenter1> extends AppCompatActivity implements IBaseView1 {

    private int i;
    public p p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = initLayoutId();
        setContentView(i);
        p = initPresenter();
        if (p!=null) {
            p.attachView(this);
        }
        initView();
        initListener();
        initData();
    }
    public abstract int initLayoutId();
    public abstract p initPresenter();
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
