package com.example.horoscopo.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
   @GET("/{sign}")
   suspend fun getSignInformation(@Path("sign") sign:String):Response
}