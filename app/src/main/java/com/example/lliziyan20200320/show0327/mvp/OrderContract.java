package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBaseView1;
import com.example.lliziyan20200320.show0327.bean.OrderBean;

public interface OrderContract {
    interface OrderView extends IBaseView1{
        void onSuccessJson(OrderBean orderBean);
        void onFailureJson(String msg);
    }
    interface OrderModel{
        void order(String orderInfo,double totalPrice,int addressId,OrderCallBack orderCallBack);
        interface OrderCallBack{
            void onSuccessJson(OrderBean orderBean);
            void onFailureJson(String msg);
        }
    }
    interface OrderPresenter{
        void order(String orderInfo,double totalPrice,int addressId);
    }
}
