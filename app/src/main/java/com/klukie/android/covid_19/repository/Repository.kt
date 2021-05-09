package com.klukie.android.covid_19.repository

<<<<<<< Updated upstream
import com.klukie.android.covid_19.api.Retrofitinstance
import com.klukie.android.covid_19.model.Post
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Post {
        return Retrofitinstance.api.getPost()
    }
=======
import com.klukie.android.covid_19.api.RetrofitInstance
import com.klukie.android.covid_19.model.Post
import retrofit2.Response

class Repository {

    suspend fun  getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }


>>>>>>> Stashed changes
}