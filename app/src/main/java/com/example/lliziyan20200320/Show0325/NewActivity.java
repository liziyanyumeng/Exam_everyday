package com.example.lliziyan20200320.Show0325;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.Show0325.adapter.FirstAdapter;
import com.example.lliziyan20200320.Show0325.adapter.SecondAdapter;
import com.example.lliziyan20200320.Show0325.bean.BannerBean;
import com.example.lliziyan20200320.Show0325.bean.ResultBean;
import com.example.lliziyan20200320.Show0325.util.ApiService;
import com.example.lliziyan20200320.Show0325.util.RetrofitUtil;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewActivity extends AppCompatActivity {
    private RecyclerView molirecycler;
    private RecyclerView pingnzhirecycler;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager manager;
    private FirstAdapter firstAdapter;
    private SecondAdapter secondAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initView();
    }

    private void initView() {
        molirecycler = (RecyclerView) findViewById(R.id.molirecycler);
        pingnzhirecycler = (RecyclerView) findViewById(R.id.pingnzhirecycler);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        molirecycler.setLayoutManager(linearLayoutManager);
        manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        pingnzhirecycler.setLayoutManager(manager);
        show();
        show2();
    }

    public void show(){
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<BannerBean> banner = apiService.banner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        final ArrayList<ResultBean> result = bannerBean.result;
                        firstAdapter = new FirstAdapter(NewActivity.this, result);
                        molirecycler.setAdapter(firstAdapter);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(NewActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete() {}
                });
    }

    public void show2(){
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<BannerBean> banner = apiService.banner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        final ArrayList<ResultBean> result = bannerBean.result;
                        secondAdapter = new SecondAdapter(NewActivity.this, result);
                        pingnzhirecycler.setAdapter(secondAdapter);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(NewActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
