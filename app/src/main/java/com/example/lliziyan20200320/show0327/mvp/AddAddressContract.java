package com.example.lliziyan20200320.show0327.mvp;

import com.example.lliziyan20200320.show0327.base.IBaseView1;
import com.example.lliziyan20200320.show0327.bean.AddressBean;
import com.example.lliziyan20200320.show0327.bean.XinzengBean;

public interface AddAddressContract {
    interface AddAddressView extends IBaseView1{
        void onSuccessJson(AddressBean addressBean);
        void onFailureJson(String msg);
    }
    interface AddAddressModel{
        void address(AddCallBack addCallBack);
        interface AddCallBack{
            void onSuccessJson(AddressBean addressBean);
            void onFailureJson(String msg);
        }
    }
    interface AddAddressPresenter{
        void address();
    }
}
