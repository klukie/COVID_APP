package com.klukie.android.covid_19.repository

import android.util.Log
import com.klukie.android.covid_19.api.RetrofitInstance
import com.klukie.android.covid_19.model.CovidPost
import com.klukie.android.covid_19.model.CovidPostResponse
import com.klukie.android.covid_19.model.Post
import retrofit2.Response


class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
    // GET REQUEST
    suspend fun getCovidPost(): Response<CovidPostResponse> {
        return RetrofitInstance.api.getCovidPost()
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    //pushPostCovid
    suspend fun pushPostCovid(post: CovidPost): Response<CovidPostResponse> {
        Log.d("Main", "INSIDE pushPostCovid FUnciton Repository")
        return RetrofitInstance.api.pushPostCovid(post)
    }
}