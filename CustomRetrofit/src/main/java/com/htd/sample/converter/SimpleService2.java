package com.htd.sample.converter;

import com.htd.sample.Contributor;
import com.htd.sample.converter.DateConverter.DateConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:24
 * <p>
 * Desc:
 */
public class SimpleService2 {
    private static final String API_URL = "https://api.github.com";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
                // 添加拦截
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor(System.out::println).setLevel(Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(DateConverterFactory.create())
                .build();
        Github2 github = retrofit.create(Github2.class);
        Call<List<Contributor>> call = github.contributors("square", "retrofit", new Date());
        List<Contributor> contributors = call.execute().body();

        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }

        github.hello();
        System.out.println(github.getClass());
    }
}
