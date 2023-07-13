package com.mawit.cats.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {

        const val API_KEY = "live_qtGxSCcsidTznorCog5L1nrVHBxiL5wRgybKIFuA5Dv70ysGMqsjdUH188cUgtkJ"

        val catRetrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogRetrofit = Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
}