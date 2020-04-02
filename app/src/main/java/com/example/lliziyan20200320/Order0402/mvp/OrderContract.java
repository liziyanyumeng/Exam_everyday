package com.example.lliziyan20200320.Order0402.mvp;

import com.example.lliziyan20200320.Order0402.base.IBaseView;
import com.example.lliziyan20200320.Order0402.bean.OrderShow;
import com.example.lliziyan20200320.show0327.bean.OrderBean;

//契约类
public interface OrderContract {
    interface OrderView extends IBaseView{
        void onSuccessJson(OrderShow orderShow);
        void onFailureJson(String msg);
    }
    interface OrderModel{
        void ordershow(int page,int count,int status,OrderCallBack orderCallBack);
        interface OrderCallBack{
            void onSuccessJson(OrderShow orderShow);
            void onFailureJson(String msg);
        }
    }
    interface OrderPresenter{
        void ordershow(int page,int count,int status);
    }
}
