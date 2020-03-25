package com.example.lliziyan20200320.mvp;

import com.example.lliziyan20200320.base.IBasePresenter;
import com.example.lliziyan20200320.bean.BannerBean;

public class ShowPresenter extends IBasePresenter<ShowContract.ShowView> implements ShowContract.ShowPresenter {

    private ShowModel showModel;

    @Override
    public void initModel() {
        showModel = new ShowModel();
    }

    @Override
    public void show() {
        showModel.show(new ShowContract.ShowModel.ShowCallBack() {
            @Override
            public void onSuccessJson(BannerBean bannerBean) {
                view.onSuccessJson(bannerBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
