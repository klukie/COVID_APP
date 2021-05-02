package com.klukie.android.covid_19.repository

import com.klukie.android.covid_19.api.Retrofitinstance
import com.klukie.android.covid_19.model.Post
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Post {
        return Retrofitinstance.api.getPost()
    }
}