package com.example.lliziyan20200320.Show0325.mvp;

import com.example.lliziyan20200320.Show0325.bean.BannerBean;
import com.example.lliziyan20200320.Show0325.util.ApiService;
import com.example.lliziyan20200320.Show0325.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShowModel implements ShowContract.ShowModel {
    @Override
    public void show(final ShowCallBack showCallBack) {
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
                        showCallBack.onSuccessJson(bannerBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        showCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
