package com.example.horoscopo.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopo.data.provider.HoroscopesProvider
import com.example.horoscopo.domain.model.HoroscopeSing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopesProvider: HoroscopesProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeSing>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeSing>> = _horoscope

    init {
        _horoscope.value = horoscopesProvider.getHoroscopes()
    }

}