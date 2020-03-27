package com.example.lliziyan20200320.show0327.util;

import com.example.lliziyan20200320.show0327.bean.LeiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("commodity/v1/findCategory")
    Observable<LeiBean> leimu();
}
