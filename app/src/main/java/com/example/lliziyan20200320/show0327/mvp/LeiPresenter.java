package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBasePresenter1;
import com.example.lliziyan20200320.show0327.bean.LeiBean;

public class LeiPresenter extends IBasePresenter1<LeiContract.LeiView> implements LeiContract.LeiPresenter {

    private LeiModel leiModel;

    @Override
    public void initPresenter() {
        leiModel = new LeiModel();
    }
    @Override
    public void lei() {
        leiModel.lei(new LeiContract.LeiModel.LeiCallBack() {
            @Override
            public void onSuccessJson(LeiBean leiBean) {
                view.onSuccessJson(leiBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
