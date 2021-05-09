package com.klukie.android.covid_19.api

import com.klukie.android.covid_19.model.Post
<<<<<<< Updated upstream
=======
import retrofit2.Response
>>>>>>> Stashed changes
import retrofit2.http.GET

interface SimpleApi {

<<<<<<< Updated upstream
    @GET( "/")
    suspend fun getPost(): Post
=======

    @GET("posts/1")

    //this will return a post which is of he model package
    suspend fun getPost(): Response<Post>
>>>>>>> Stashed changes
}