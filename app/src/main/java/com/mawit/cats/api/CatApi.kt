package com.mawit.cats.api

import com.mawit.cats.model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatApi {

    @GET("v1/images/search")
    suspend fun catRandom() : Response<List<Cat>>

    @GET("v1/images/search?limit=10&api_key=${RetrofitHelper.API_KEY}")
    suspend fun cat10Random() : Response<List<Cat>>


}