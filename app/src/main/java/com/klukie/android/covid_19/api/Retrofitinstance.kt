package com.klukie.android.covid_19.api

import com.google.gson.GsonBuilder
import com.klukie.android.covid_19.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    //object key to make retrofit instance a singleton
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }


}