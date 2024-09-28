package com.htd.sample;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:15
 * <p>
 * Desc:
 */
public interface Github {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);

    default void hello() {
        System.out.println("this is a default method");
    }

    @GET("/repos/{owner}/{repo}")
    Observable<Repository> repo(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}")
    Observable<Response<Repository>> repo2(@Path("owner") String owner, @Path("repo") String repo);
}
