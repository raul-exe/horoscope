package com.example.horoscopo.domain.model

data class ResponseModel(
    val date: String,
    val horoscopeDescription: String,
    val signIcon: String,
    val singName:String
)