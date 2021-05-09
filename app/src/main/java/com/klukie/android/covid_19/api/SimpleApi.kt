package com.klukie.android.covid_19.api

import com.klukie.android.covid_19.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")

    //this will return a post which is of he model package
    suspend fun getPost(): Response<Post>
}