package com.example.horoscopo.domain

import com.example.horoscopo.domain.model.ResponseModel

interface HoroscopeRepository {
    suspend fun getPrediction(sign:String):ResponseModel?
}