package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.bean.AddressBean;
import com.example.lliziyan20200320.show0327.util.ApiService;
import com.example.lliziyan20200320.show0327.util.RetrofitUtil1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddAddressModel implements AddAddressContract.AddAddressModel {
    @Override
    public void address(final AddCallBack addCallBack) {
        final RetrofitUtil1 instance = RetrofitUtil1.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<AddressBean> adderess = apiService.adderess();
        adderess.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(AddressBean addressBean) {
                        addCallBack.onSuccessJson(addressBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        addCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
