package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.bean.LeiBean;
import com.example.lliziyan20200320.show0327.util.ApiService;
import com.example.lliziyan20200320.show0327.util.RetrofitUtil1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LeiModel implements LeiContract.LeiModel {
    @Override
    public void lei(final LeiCallBack leiCallBack) {
        final RetrofitUtil1 instance = RetrofitUtil1.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<LeiBean> leimu = apiService.leimu();
        leimu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(LeiBean leiBean) {
                        leiCallBack.onSuccessJson(leiBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        leiCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
