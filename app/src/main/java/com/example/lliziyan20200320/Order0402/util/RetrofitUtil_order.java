package com.example.lliziyan20200320.Order0402.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil_order {
    private static RetrofitUtil_order instance;
    private static String baseUrl = "http://mobile.bwstudent.com/small/order/";
    private final Retrofit retrofit;

    private RetrofitUtil_order() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient builder = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        final Request request = chain.request();
                        final Request.Builder builder1 = request.newBuilder();
                        builder1.addHeader("userId","33874");
                        builder1.addHeader("sessionId","158580730402033874");
                        final Request build = builder1.build();
                        return chain.proceed(build);
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtil_order getInstance() {
        if (instance == null) {
            instance = new RetrofitUtil_order();
        }
        return instance;
    }
    public ApiService_Order apiService_order(){
        final ApiService_Order apiService_order = retrofit.create(ApiService_Order.class);
        return apiService_order;
    }
}
