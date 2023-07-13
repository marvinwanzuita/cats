package com.mawit.cats.api

import com.mawit.cats.model.Cat
import com.mawit.cats.model.Dog
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {

    @GET("v1/images/search")
    suspend fun dogRandom() : Response<List<Dog>>

    @GET("v1/images/search?limit=10&api_key=${RetrofitHelper.API_KEY}")
    suspend fun dog10Random() : Response<List<Dog>>

}