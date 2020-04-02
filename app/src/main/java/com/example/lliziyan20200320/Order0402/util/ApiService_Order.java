package com.example.lliziyan20200320.Order0402.util;

import com.example.lliziyan20200320.Order0402.bean.OrderShow;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService_Order {
    @GET("verify/v1/findOrderListByStatus")
    Observable<OrderShow> order(@Query("page")int page,@Query("count")int count,@Query("status")int status);
}
