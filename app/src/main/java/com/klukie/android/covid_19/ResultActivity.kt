package com.klukie.android.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klukie.android.covid_19.model.CovidPost
import com.klukie.android.covid_19.repository.Repository
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    //these are the variables foe the GET test
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var underlyingHashMap = intent.getSerializableExtra("underlyingHashMap") as HashMap<String, Int>

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.toString())
        })


        //-------------------------------------
        //POST POST POST
        //TEST TEST TEST
        var myPost = CovidPost(
            underlyingHashMap["age"],
            underlyingHashMap["sex"],
            underlyingHashMap["patient_type"],
            underlyingHashMap["intubed"],
            underlyingHashMap["pneumonia"],
            underlyingHashMap["pregnancy"],
            underlyingHashMap["diabetes"],
            underlyingHashMap["copd"],
            underlyingHashMap["asthma"],
            underlyingHashMap["inmsupr"],
            underlyingHashMap["hypertension"],
            underlyingHashMap["other_disease"],
            underlyingHashMap["cardiovascular"],
            underlyingHashMap["obesity"],
            underlyingHashMap["renal_chronic"],
            underlyingHashMap["tobacco"],
            underlyingHashMap["covid_res"],
            underlyingHashMap["contact_other_covid"],
            underlyingHashMap["icu"],
        )

        viewModel.pushPostCovid(myPost)
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
//                    Log.d("Main", response.body()?.userId.toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
                textView2.text = response.body()?.Result.toString()
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })


    }
}