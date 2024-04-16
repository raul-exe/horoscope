package com.example.horoscopo.ui.horoscopedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopo.domain.model.HoroscopeType
import com.example.horoscopo.domain.usecase.GetPredictionBySignUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionBySignUseCase: GetPredictionBySignUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeType
    fun getPredictionBySign(sign: HoroscopeType) {
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val response = withContext(Dispatchers.IO) { getPredictionBySignUseCase(horoscope.name) }
            if (response != null) {
                _state.value = HoroscopeDetailState.Success(response,horoscope)
            } else {
                _state.value = HoroscopeDetailState.Error("Error")
            }
        }
    }

}