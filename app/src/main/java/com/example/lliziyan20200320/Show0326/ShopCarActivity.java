package com.example.lliziyan20200320.Show0326;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.Show0326.adapter.ShopAdapter;
import com.example.lliziyan20200320.Show0326.bean.ResultShop;
import com.example.lliziyan20200320.Show0326.bean.ShopCarBean;
import com.example.lliziyan20200320.Show0326.net.ApiService;
import com.example.lliziyan20200320.Show0326.net.NetUtil;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopCarActivity extends AppCompatActivity {

    private RecyclerView recyclerShop;
    private LinearLayoutManager linearLayoutManager;
    private ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_car);
        initView();
    }
    private void initView() {
        recyclerShop = (RecyclerView) findViewById(R.id.recycler_shop);
        //添加布局管理器
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerShop.setLayoutManager(linearLayoutManager);
        show();
    }
    public void show(){
        final NetUtil instance = NetUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<ShopCarBean> shopcar = apiService.shopcar();
        shopcar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopCarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(ShopCarBean shopCarBean) {
                        Toast.makeText(ShopCarActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        final ArrayList<ResultShop> result = shopCarBean.result;
                        shopAdapter = new ShopAdapter(ShopCarActivity.this, result);
                        recyclerShop.setAdapter(shopAdapter);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ShopCarActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
