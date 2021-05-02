package com.klukie.android.covid_19.api

import com.klukie.android.covid_19.model.Post
import retrofit2.http.GET

interface SimpleApi {

    @GET( "/")
    suspend fun getPost(): Post
}