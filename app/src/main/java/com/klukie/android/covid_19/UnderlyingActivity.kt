package com.klukie.android.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klukie.android.covid_19.model.CovidPost
import com.klukie.android.covid_19.model.Post
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

        // Creating A HashMap that will store all the Underlying Conditions
        val underlyingHashMap: HashMap<String, Int> = HashMap()

        //after button pushed ifChecked will populate the array
        //everytime button is pushed it will clear the array and start fresh
        sendRequestArrow.setOnClickListener {
            underlyingList.clear()

            //The first 3 elements are sex, age and ethnicity
            if (sex != null) {
                if(sex == "Male") {
                    underlyingHashMap.put("sex", 2)
                }
                else {
                    underlyingHashMap.put("sex", 1)
                }
            }
            if (age != null) {
                underlyingHashMap.put("age", age.toInt())
            }
            //Don't Care about ethnicity for post request
//            if (ethnicity != null) {
//                underlyingList.add(ethnicity)
//            }
            if(asthmaBox.isChecked) {
                underlyingHashMap.put("asthma", 1)
            }
            else {
                underlyingHashMap.put("asthma", 2)
            }
            if(cardiovascularBox.isChecked) {
                underlyingHashMap.put("cardiovascular", 1)
            }
            else {
                underlyingHashMap.put("cardiovascular", 2)
            }


            if(chronicLungBox.isChecked) {
                underlyingHashMap.put("tobacco", 1)
            }
            else {
                underlyingHashMap.put("tobacco", 2)
            }


            if(immuneBox.isChecked) {
                underlyingHashMap.put("inmsupr", 1)
            }
            else {
                underlyingHashMap.put("inmsupr", 2)
            }
            if(metabolicBox.isChecked) {
                underlyingHashMap.put("intubed", 1)
            }
            else {
                underlyingHashMap.put("intubed", 2)
            }

            if(neurologicBox.isChecked) {
                underlyingHashMap.put("icu", 1)
            }
            else {
                underlyingHashMap.put("icu", 2)
            }
            if(otherBox.isChecked) {
                underlyingHashMap.put("other_disease", 1)
            }
            else {
                underlyingHashMap.put("other_disease", 2)
            }

            if(autoimmuneBox.isChecked) {
                underlyingHashMap.put("copd", 1)
            }
            else {
                underlyingHashMap.put("copd", 2)
            }

            if(obesityBox.isChecked) {
                underlyingHashMap.put("obesity", 1)
            }
            else {
                underlyingHashMap.put("obesity", 2)
            }

            if(pregnancyBox.isChecked) {
                underlyingHashMap.put("pregnancy", 1)
            }
            else {
                underlyingHashMap.put("pregnancy", 2)
            }

            if(renalBox.isChecked) {
                underlyingHashMap.put("renal_chronic", 1)
            }
            else {
                underlyingHashMap.put("renal_chronic", 2)
            }

            if(gastrointestinalBox.isChecked) {
                underlyingHashMap.put("diabetes", 1)
            }
            else {
                underlyingHashMap.put("diabetes", 2)
            }

            if(hypertensionBox.isChecked) {
                underlyingHashMap.put("hypertension", 1)
            }
            else {
                underlyingHashMap.put("hypertension", 2)
            }

            // These are extras
            underlyingHashMap.put("patient_type", 2)
            underlyingHashMap.put("pneumonia", 2)
            underlyingHashMap.put("contact_other_covid", 2)
            underlyingHashMap.put("covid_res", 2)

            //Go to the Result Activity
            openResultActivity(underlyingHashMap)
        }
    }

    //method to inflate next activity and pass data
    private fun openResultActivity(underlyingHashMap: HashMap<String, Int>) {
        val intent : Intent =  Intent(this, ResultActivity::class.java)
        intent.putExtra("underlyingHashMap", underlyingHashMap)
        startActivity(intent)
    }
}