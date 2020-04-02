package com.example.lliziyan20200320.Order0402.mvp;

import com.example.lliziyan20200320.Order0402.bean.OrderShow;
import com.example.lliziyan20200320.Order0402.util.ApiService_Order;
import com.example.lliziyan20200320.Order0402.util.RetrofitUtil_order;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderModel implements OrderContract.OrderModel {
    @Override
    public void ordershow(int page, int count, int status, final OrderCallBack orderCallBack) {
        final RetrofitUtil_order instance = RetrofitUtil_order.getInstance();
        final ApiService_Order apiService_order = instance.apiService_order();
        final Observable<OrderShow> order = apiService_order.order(page, count, status);
        order.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderShow>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(OrderShow orderShow) {
                        orderCallBack.onSuccessJson(orderShow);
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
