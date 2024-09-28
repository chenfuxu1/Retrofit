package com.htd.sample.deferred

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "https://api.github.com"

suspend fun main() {
    val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(DeferredAdapterFactory.create())
            .build()
    val github: GithubKt = retrofit.create(GithubKt::class.java)
    var call = github.contributors("square", "retrofit")
    GlobalScope.launch {
        val contributors = call.await()
        contributors.forEach { contributor ->
            println( """${contributor.login} (${contributor.contributors})""")
        }
    }.join()

}