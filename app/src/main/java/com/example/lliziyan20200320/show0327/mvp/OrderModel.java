package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.Show0325.util.RetrofitUtil;
import com.example.lliziyan20200320.show0327.bean.OrderBean;
import com.example.lliziyan20200320.show0327.util.ApiService;
import com.example.lliziyan20200320.show0327.util.RetrofitUtil1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderModel implements OrderContract.OrderModel {
    @Override
    public void order(String orderInfo, double totalPrice, int addressId, final OrderCallBack orderCallBack) {
        final RetrofitUtil1 instance = RetrofitUtil1.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<OrderBean> order = apiService.createOrder(orderInfo, totalPrice, addressId);
        order.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(OrderBean orderBean) {
                        orderCallBack.onSuccessJson(orderBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        orderCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
