package com.klukie.android.covid_19.model

data class CovidPost(
    // 1 represents yes or female
    // 2 represents no or male
    val age: Int?,
    val sex: Int?,
    val patient_type: Int?,
    val intubed: Int?,
    val pneumonia: Int?,
    val pregnancy: Int?,
    val diabetes: Int?,
    val copd: Int?,
    val asthma: Int?,
    val inmsupr: Int?,
    val hypertension: Int?,
    val other_disease: Int?,
    val cardiovascular: Int?,
    val obesity: Int?,
    val renal_chronic: Int?,
    val tobacco: Int?,
    val covid_res: Int?,
    val contact_other_covid: Int?,
    val icu: Int?,
)