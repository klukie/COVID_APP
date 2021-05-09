package com.klukie.android.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klukie.android.covid_19.model.Post
import com.klukie.android.covid_19.repository.Repository
import kotlinx.android.synthetic.main.activity_underlying.*

class UnderlyingActivity : AppCompatActivity() {

    //these are the variables foe the GET test
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_underlying)

        //collecting data from previous activity
        var intent = intent
        val sex = intent.getStringExtra("sex")
        val age = intent.getStringExtra("age")
        val ethnicity = intent.getStringExtra("ethnicity")

<<<<<<< HEAD
        lateinit var viewModel: MainViewModel
=======
>>>>>>> ebafdee5615215a50baddbc2e1f0afe67e3ab544

        //create arrayList to store all underlying
        val underlyingList : MutableList<String> = ArrayList()


        //TEST TEST TEST TEST
        //should display on the bottom of the second page
        //These are for the GET test
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                tv3.text = response.body()?.userId.toString()
                Log.d("Response", response.body()?.id.toString())
                tv2.text = response.body()?.id.toString()
                Log.d("Response", response.body()?.title!!)
                tv1.text = response.body()?.title!!
                Log.d("Response", response.body()?.body!!)
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })




        //after button pushed ifChecked will populate the array
        //everytime button is pushed it will clear the array and start fresh
        //TODO need to convert to 1's and 2's to send POST Request
        sendRequestArrow.setOnClickListener {
            underlyingList.clear()

            //The first 3 elements are sex, age and ethnicity
            if (sex != null) {
                underlyingList.add(sex)
            }
            if (age != null) {
                underlyingList.add(age)
            }
            if (ethnicity != null) {
                underlyingList.add(ethnicity)
            }
            if(asthmaBox.isChecked) {
                underlyingList.add("Asthma")
            }
            if(cardiovascularBox.isChecked) {
                underlyingList.add("Cardiovascular disease")
            }
            if(chronicLungBox.isChecked) {
                underlyingList.add("Chronic lung disease")
            }
            if(immuneBox.isChecked) {
                underlyingList.add("Immune suppression")
            }
            if(metabolicBox.isChecked) {
                underlyingList.add("Metabolic disease")
            }
            if(neurologicBox.isChecked) {
                underlyingList.add("Neurologic disease")
            }
            if(otherBox.isChecked) {
                underlyingList.add("Other disease")
            }
            if(autoimmuneBox.isChecked) {
                underlyingList.add("Autoimmune disease ")
            }
            if(obesityBox.isChecked) {
                underlyingList.add("Obesity")
            }
            if(pregnancyBox.isChecked) {
                underlyingList.add("Pregnancy")
            }
            if(renalBox.isChecked) {
                underlyingList.add("Renal disease")
            }
            if(gastrointestinalBox.isChecked) {
                underlyingList.add("Gastrointestinal/liver disease")
            }
            if(hypertensionBox.isChecked) {
                underlyingList.add("Hypertension")
            }
            for (item in underlyingList)
                println(item)


            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            viewModel.getPost()     //This will get the result from the function
            //
            viewModel.myResponse.observe(this, Observer { response ->
                Log.d("Response", response.toString())
            })


            //-------------------------------------
            //POST POST POST
            //TEST TEST TEST
            val myPost = Post(10, 2, "Ryan", "Software Class")
            viewModel.pushPost(myPost)
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    Log.d("Main", response.body()?.userId.toString())
                    Log.d("Main", response.code().toString())
                    Log.d("Main", response.message())
                } else {
                    Log.d("Response", response.errorBody().toString())
                }
            })




        }

    }

}