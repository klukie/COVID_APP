package com.klukie.android.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klukie.android.covid_19.repository.Repository
import kotlinx.android.synthetic.main.activity_underlying.*

class UnderlyingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_underlying)

        //collecting data from previous activity
        var intent = intent
        val sex = intent.getStringExtra("sex")
        val age = intent.getStringExtra("age")
        val ethnicity = intent.getStringExtra("ethnicity")

        lateinit var viewModel: MainViewModel

        //create arrayList to store all underlying
        val underlyingList : MutableList<String> = ArrayList()

        //after button pushed ifChecked will populate the array
        //everytime button is pushed it will clear the array and start fresh
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
                Log.d("Response", response.result.toString())
            })


        }

    }

}