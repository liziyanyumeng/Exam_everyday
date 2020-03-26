package com.example.lliziyan20200320.Show0326.mvp;

import com.example.lliziyan20200320.Show0326.bean.ShopCarBean;
import com.example.lliziyan20200320.base.IBaseView;

public interface ShopContract {
    interface ShopView extends IBaseView{
        void onSuccessJson(ShopCarBean shopCarBean);
        void onFailureJson(String msg);
    }
    interface ShopModel{
        void shop(ShopCallBack shopCallBack);
        interface ShopCallBack{
            void onSuccessJson(ShopCarBean shopCarBean);
            void onFailureJson(String msg);
        }
    }
    interface ShopPresenter{
        void shop();
    }
}
