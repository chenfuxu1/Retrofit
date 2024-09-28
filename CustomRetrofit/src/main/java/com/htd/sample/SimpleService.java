package com.htd.sample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:24
 * <p>
 * Desc:
 */
public class SimpleService {
    private static final String API_URL = "https://api.github.com";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
                // 添加拦截
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor(System.out::println).setLevel(Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create()).build();
        Github github = retrofit.create(Github.class);
        Call<List<Contributor>> call = github.contributors("square", "retrofit");
        List<Contributor> contributors = call.execute().body();

        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }

        github.hello();
        System.out.println(github.getClass());
    }
}
