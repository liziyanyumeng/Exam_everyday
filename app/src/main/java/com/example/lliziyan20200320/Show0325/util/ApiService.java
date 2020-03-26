package com.example.lliziyan20200320.Show0325.util;

import com.example.lliziyan20200320.Show0325.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("commodity/v1/commodityList")
    Observable<BannerBean> banner();

}
