package com.example.lliziyan20200320.mvp;

import com.example.lliziyan20200320.base.IBaseView;
import com.example.lliziyan20200320.bean.BannerBean;

public interface ShowContract {
    interface ShowView extends IBaseView{
        void onSuccessJson(BannerBean bannerBean);
        void onFailureJson(String msg);
    }
    interface ShowModel{
        void show(ShowCallBack showCallBack);
        interface ShowCallBack{
            void onSuccessJson(BannerBean bannerBean);
            void onFailureJson(String msg);
        }
    }
    interface ShowPresenter{
        void show();
    }
}
