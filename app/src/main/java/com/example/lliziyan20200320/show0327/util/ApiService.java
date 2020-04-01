package com.example.lliziyan20200320.show0327.util;

import com.example.lliziyan20200320.show0327.bean.AddressBean;
import com.example.lliziyan20200320.show0327.bean.LeiBean;
import com.example.lliziyan20200320.show0327.bean.OrderBean;
import com.example.lliziyan20200320.show0327.bean.XinzengBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("commodity/v1/findCategory")
    Observable<LeiBean> leimu();

    @POST("order/verify/v1/createOrder")
    @FormUrlEncoded
    Observable<OrderBean> createOrder(@Field("orderInfo")String orderInfo,@Field("totalPrice")double totalPrice,@Field("addressId") int addressId);

    //收货地址列表
    @GET("user/verify/v1/receiveAddressList")
    Observable<AddressBean> adderess();

    //新增收货地址
    @POST("user/verify/v1/setDefaultReceiveAddress")
    @FormUrlEncoded
    Observable<XinzengBean> addDingdan(@Field("realName")String realName,@Field("phone")String phone,@Field("address")String address,@Field("zipCode") int zipCode);
}
