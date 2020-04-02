package com.example.lliziyan20200320.Order0402.mvp;

import com.example.lliziyan20200320.Order0402.base.IBasePresenter;
import com.example.lliziyan20200320.Order0402.bean.OrderShow;

public class OrderPresenter extends IBasePresenter<OrderContract.OrderView> implements OrderContract.OrderPresenter {

    private OrderModel orderModel;

    @Override
    public void initModel() {
        orderModel = new OrderModel();
    }
    @Override
    public void ordershow(int page, int count, int status) {
        orderModel.ordershow(page, count, status, new OrderContract.OrderModel.OrderCallBack() {
            @Override
            public void onSuccessJson(OrderShow orderShow) {
                view.onSuccessJson(orderShow);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
