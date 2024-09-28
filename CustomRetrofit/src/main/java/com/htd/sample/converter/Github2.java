package com.htd.sample.converter;

import com.htd.sample.Contributor;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;
import java.util.List;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-25 23:15
 * <p>
 * Desc:
 */
public interface Github2 {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo, @Query("current") Date date);

    default void hello() {
        System.out.println("this is a default method");
    }
}
