package com.example.horoscopo.core.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor( private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", tokenManager.getTokenAuthorization())
            .build()

        return chain.proceed(request)
    }
}

/**
 * Clase de ejemplo no debe de ir aquí,
 * representa una clase encargada de gestionar el almacenamiento
 * del token de autorizacion para realizar las peticiones
 * */
class TokenManager @Inject constructor() {
    fun getTokenAuthorization(): String {
        return "asdadadadadsdadada"
    }
}