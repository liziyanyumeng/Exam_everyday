package com.example.lliziyan20200320.Show0326.mvp;

import com.example.lliziyan20200320.Show0326.bean.ShopCarBean;
import com.example.lliziyan20200320.Show0326.net.ApiService;
import com.example.lliziyan20200320.Show0326.net.NetUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopModel implements ShopContract.ShopModel {
    @Override
    public void shop(final ShopCallBack shopCallBack) {
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
                        shopCallBack.onSuccessJson(shopCarBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        shopCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
