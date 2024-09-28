package com.htd.sample.baseurl;

import com.htd.sample.Contributor;
import com.htd.sample.Github;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:24
 * <p>
 * Desc:
 */
public class SimpleService3 {
    private static final String API_URL = "https://api.github.com";
    private static final String FALSE_API_HOST = "false.api.github.com";

    public static void main(String[] args) throws IOException {
        HttpUrlHelper httpUrlHelper = new HttpUrlHelper(HttpUrl.get(API_URL));

        Retrofit retrofit = new Retrofit.Builder().baseUrl(httpUrlHelper.getHttpUrl())
                // 添加拦截
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor(System.out::println).setLevel(Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create()).build();
        Github github = retrofit.create(Github.class);
        getContributors(github);
        httpUrlHelper.setHost(FALSE_API_HOST);
        getContributors(github);
    }

    private static void getContributors(Github github) throws IOException {
        Call<List<Contributor>> call = github.contributors("square", "retrofit");
        List<Contributor> contributors = call.execute().body();

        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }

        github.hello();
        System.out.println(github.getClass());
    }
}
