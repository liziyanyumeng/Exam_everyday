package com.example.lliziyan20200320.Show0326.net;

import com.example.lliziyan20200320.Show0326.bean.ShopCarBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("order/verify/v1/findShoppingCart")
    Observable<ShopCarBean> shopcar();
}
