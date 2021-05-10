package com.klukie.android.covid_19.api

import com.klukie.android.covid_19.model.CovidPost
import com.klukie.android.covid_19.model.CovidPostResponse
import com.klukie.android.covid_19.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SimpleApi {

    @GET("posts/1")
    //this will return a post which is of the model package
    suspend fun getPost(): Response<Post>


    @GET("/")
    //this will return a post which is of the model package
    suspend fun getCovidPost(): Response<CovidPostResponse>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    //This will call a post http request using the CovidPost As the Body
    @POST("result")
    suspend fun pushPostCovid(
        @Body post: CovidPost
    ): Response<CovidPostResponse>


}