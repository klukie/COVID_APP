package com.klukie.android.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var sex : String
    lateinit var ethnicity : String
    lateinit var age : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //populate the spinners
        setupEthnicitySpinner()
        setupSexSpinner()
        setUpAgeSpinner()

        //button to advance checks to see if every spinner is selected
        underLyingButton.setOnClickListener {
            if(sex == "Make a selection" ||
                    ethnicity == "Make a selection" ||
                    age == "Make a selection") {
                Toast.makeText(this,
                        "Please make a selection",
                        Toast.LENGTH_SHORT).show()
            } else {
                /*Toast to make sure all data is correct
                Toast.makeText(this,
                        "Sex selected = $sex\n" +
                                "Age selected = $age\n" +
                                "Ethnicity selected = $ethnicity",
                        Toast.LENGTH_SHORT).show()
                 */
                openUnderlying()
            }
        }
    }

    //method to inflate next activity and pass data
    private fun openUnderlying() {
        val intent : Intent =  Intent(this, UnderlyingActivity::class.java)
        intent.putExtra("sex", sex)
        intent.putExtra("ethnicity", ethnicity)
        intent.putExtra("age", age)
        startActivity(intent)
    }

    //populate the age spinner
    private fun setUpAgeSpinner() {
        val ageList : MutableList<String> = ArrayList()

        ageList.add("Make a selection")
        for (i : Int in 1..120)
            ageList.add(i.toString())

        val adapter : ArrayAdapter<String> = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, ageList)
        ageSpinner.adapter = adapter

        ageSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                /*Toast to show selected data
                Toast.makeText(this@MainActivity,
                "$selectedItem",
                Toast.LENGTH_SHORT)
                        .show()

                 */
                age = "$selectedItem"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }


    //populate sex spinner
    private fun setupSexSpinner() {
        val adapter = ArrayAdapter.createFromResource(this,
        R.array.sex,
        android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sexSpinner.adapter = adapter

        sexSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                /*Toast to show data
                Toast.makeText(this@MainActivity,
                "$selectedItem", Toast.LENGTH_SHORT).show()
                */
                sex = "$selectedItem"

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,
                    "Nothing selected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //populate ethnicity spinner
    private fun setupEthnicitySpinner() {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.ethnicity,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ethnicitySpinner.adapter = adapter

        ethnicitySpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                /*Toast to show data
                Toast.makeText(this@MainActivity,
                "$selectedItem", Toast.LENGTH_SHORT).show()
                 */
                ethnicity = "$selectedItem"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,
                    "Nothing selected", Toast.LENGTH_SHORT).show()
            }

        }

    }
}