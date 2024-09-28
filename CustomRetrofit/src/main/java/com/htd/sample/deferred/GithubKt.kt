package com.htd.sample.deferred

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 17:06
 *
 * Desc: 支持协程
 */
interface GithubKt {
    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(@Path("owner") owner: String, @Path("repo") repo: String) : Deferred<List<Contributor>>

    class Contributor(val login: String, val contributors: Int)
}