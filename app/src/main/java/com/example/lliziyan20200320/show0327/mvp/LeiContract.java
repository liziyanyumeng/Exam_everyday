package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBaseView1;
import com.example.lliziyan20200320.show0327.bean.LeiBean;

public interface LeiContract {
    interface LeiView extends IBaseView1{
        void onSuccessJson(LeiBean leiBean);
        void onFailureJson(String msg);
    }
    interface LeiModel{
        void lei(LeiCallBack leiCallBack);
        interface LeiCallBack{
            void onSuccessJson(LeiBean leiBean);
            void onFailureJson(String msg);
        }
    }
    interface LeiPresenter{
        void lei();
    }
}
