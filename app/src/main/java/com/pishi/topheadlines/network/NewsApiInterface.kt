package com.pishi.topheadlines.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("/v2/top-headlines")
    fun getTopHeadlines(@Query("api_key") key : String): Call<PopularNews>
}