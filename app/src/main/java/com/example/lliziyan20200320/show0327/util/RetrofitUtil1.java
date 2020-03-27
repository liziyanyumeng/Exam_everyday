package com.example.lliziyan20200320.show0327.util;

import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil1 {
    private static RetrofitUtil1 instance;
    private static String baseUrl = "http://mobile.bwstudent.com/small/";
    private final Retrofit retrofit;

    private RetrofitUtil1() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient builder = new OkHttpClient.Builder()
                .connectTimeout(56, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil1 getInstance() {
        if (instance == null) {
            instance = new RetrofitUtil1();
        }
        return instance;
    }
    public ApiService apiService(){
        final ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
