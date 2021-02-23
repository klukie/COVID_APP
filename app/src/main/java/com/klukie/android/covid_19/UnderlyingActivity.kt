package com.klukie.android.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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



        //test display of data
        //sexPass.text = sex
        //agePass.text  = age
        //ethnicityPass.text = ethnicity

        //create arrayList to store all underlying
        val underlyingList : MutableList<String> = ArrayList()

        //after button pushed ifChecked will populate the array
        //everytime button is pushed it will clear the array and start fresh
        sendRequestArrow.setOnClickListener {
            underlyingList.clear()
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


        }


    }

}