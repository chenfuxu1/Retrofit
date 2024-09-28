package com.htd.sample.rxjavaadapter;

import com.htd.sample.Contributor;
import com.htd.sample.Github;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:24
 * <p>
 * Desc: 创建 RxJavaAdapter
 */
public class SimpleService4 {
    private static final String API_URL = "https://api.github.com";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
                // 添加拦截
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor(System.out::println).setLevel(Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Github github = retrofit.create(Github.class);
        // getRespository(github);
        getRespository2(github);
    }

    // private static void getRespository(Github github) {
    //     github.repo("square", "retrofit").subscribe(System.out::println);
    // }

    private static void getRespository2(Github github) {
        github.repo2("square", "retrofit").subscribe(response -> {
            System.out.println("cfx " + response.body());
        });
    }
}
