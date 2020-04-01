package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBasePresenter1;
import com.example.lliziyan20200320.show0327.bean.OrderBean;

public class orderpresenter extends IBasePresenter1<OrderContract.OrderView> implements OrderContract.OrderPresenter {

    private OrderModel orderModel;

    @Override
    public void initPresenter() {
        orderModel = new OrderModel();
    }

    @Override
    public void order(String orderInfo, double totalPrice, int addressId) {
        orderModel.order(orderInfo, totalPrice, addressId, new OrderContract.OrderModel.OrderCallBack() {
            @Override
            public void onSuccessJson(OrderBean orderBean) {
                view.onSuccessJson(orderBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
