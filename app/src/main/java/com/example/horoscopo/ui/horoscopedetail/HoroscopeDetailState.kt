package com.example.horoscopo.ui.horoscopedetail

import com.example.horoscopo.domain.model.HoroscopeType
import com.example.horoscopo.domain.model.ResponseModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Success(val data: ResponseModel, val horoscopeType: HoroscopeType):HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
}