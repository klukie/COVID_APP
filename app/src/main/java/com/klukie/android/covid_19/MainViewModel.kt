package com.klukie.android.covid_19

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klukie.android.covid_19.model.Post
import com.klukie.android.covid_19.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {

        viewModelScope.launch {
            val response :Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }
}


