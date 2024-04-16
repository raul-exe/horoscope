package com.example.horoscopo.data.network

import com.example.horoscopo.domain.model.ResponseModel
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("date")
    val date: String,
    @SerializedName("horoscope")
    val horoscopeDescription:String,
    @SerializedName("icon")
    val signIcon:String,
    @SerializedName("id")
    val id:Int,
    @SerializedName("sign")
    val signName:String
)

fun Response.toDomain():ResponseModel{
    return ResponseModel(
        date = date,
        signIcon = signIcon,
        horoscopeDescription = horoscopeDescription,
        singName = signName
    )
}