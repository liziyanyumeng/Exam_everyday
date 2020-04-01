package com.example.lliziyan20200320.show0327.util;

import android.widget.TextView;

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
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        final Request request = chain.request();
                        final Request.Builder builder1 = request.newBuilder();
                        builder1.addHeader("userId","33874");
                        builder1.addHeader("sessionId","158572533301433874");
                        final Request build = builder1.build();
                        return chain.proceed(build);
                    }
                })
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
