package com.example.horoscopo.data

import android.util.Log
import com.example.horoscopo.data.network.HoroscopeApiService
import com.example.horoscopo.data.network.toDomain
import com.example.horoscopo.domain.HoroscopeRepository
import com.example.horoscopo.domain.model.ResponseModel
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(private val horoscopeApiService: HoroscopeApiService) :
    HoroscopeRepository {
    override suspend fun getPrediction(sign: String): ResponseModel? {
        runCatching { horoscopeApiService.getSignInformation(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.e("HoroscopeRequest", "Error: ${it.message}") }
        return null
    }
}


//Telefono Axa 24/7 asesoria para poliza
//800 292 2273
//Atencion cliente 5551691000
//My  Axa App numero de poliza y contraseña nueva

