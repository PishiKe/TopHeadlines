package com.pishi.topheadlines.network

import com.pishi.topheadlines.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET(Constants.ENDPOINT_URL)
    fun getTopHeadlines(
        @Query(Constants.API_KEY) apiKey : String,
        @Query(Constants.COUNTRY) country : String
    ): Call<TopHeadlines>
}