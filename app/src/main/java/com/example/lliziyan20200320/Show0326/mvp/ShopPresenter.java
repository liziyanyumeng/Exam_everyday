package com.example.lliziyan20200320.Show0326.mvp;

import com.example.lliziyan20200320.Show0326.bean.ShopCarBean;
import com.example.lliziyan20200320.base.IBasePresenter;

public class ShopPresenter extends IBasePresenter<ShopContract.ShopView> implements ShopContract.ShopPresenter {

    private ShopModel shopModel;

    @Override
    public void shop() {
        shopModel = new ShopModel();
    }
    @Override
    public void initModel() {
        shopModel.shop(new ShopContract.ShopModel.ShopCallBack() {
            @Override
            public void onSuccessJson(ShopCarBean shopCarBean) {
                view.onSuccessJson(shopCarBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
