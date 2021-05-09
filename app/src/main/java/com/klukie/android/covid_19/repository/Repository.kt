package com.klukie.android.covid_19.repository

import com.klukie.android.covid_19.api.RetrofitInstance
import com.klukie.android.covid_19.model.Post
import retrofit2.Response


class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }


}