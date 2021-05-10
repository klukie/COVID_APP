package com.klukie.android.covid_19

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klukie.android.covid_19.model.CovidPost
import com.klukie.android.covid_19.model.CovidPostResponse
import com.klukie.android.covid_19.model.Post
import com.klukie.android.covid_19.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<CovidPostResponse>> = MutableLiveData()

//    fun pushPost(post: Post) {
//        viewModelScope.launch {
//            val response: Response<Post> = repository.pushPost(post)
//            myResponse.value = response
//        }
//    }

    fun pushPostCovid(post: CovidPost) {
        viewModelScope.launch {
            Log.d("Main", "INSIDE pushPostCovid FUnciton ViewModel")
            val response: Response<CovidPostResponse> = repository.pushPostCovid(post)
            myResponse.value = response
        }
    }

    fun getCovidPost() {
        viewModelScope.launch {
            val response :Response<CovidPostResponse> = repository.getCovidPost()
            myResponse.value = response
        }
    }
//
//    fun getPost() {
//
//        viewModelScope.launch {
//            val response :Response<Post> = repository.getPost()
//            myResponse.value = response
//        }
//    }
}


