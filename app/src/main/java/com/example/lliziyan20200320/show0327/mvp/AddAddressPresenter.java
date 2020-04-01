package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBasePresenter1;
import com.example.lliziyan20200320.show0327.bean.AddressBean;
import com.example.lliziyan20200320.show0327.bean.XinzengBean;

public class AddAddressPresenter extends IBasePresenter1<AddAddressContract.AddAddressView> implements AddAddressContract.AddAddressPresenter {

    private AddAddressModel addAddressModel;

    @Override
    public void initPresenter() {
        addAddressModel = new AddAddressModel();
    }

    @Override
    public void address() {
        addAddressModel.address(new AddAddressContract.AddAddressModel.AddCallBack() {
            @Override
            public void onSuccessJson(AddressBean addressBean) {
                view.onSuccessJson(addressBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
