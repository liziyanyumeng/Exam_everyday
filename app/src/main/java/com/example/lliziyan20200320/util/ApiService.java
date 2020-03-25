package com.example.lliziyan20200320.util;

import com.example.lliziyan20200320.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("commodity/v1/commodityList")
    Observable<BannerBean> banner();

}
