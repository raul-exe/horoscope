package com.example.horoscopo.data.provider

import com.example.horoscopo.domain.model.HoroscopeSing
import com.example.horoscopo.domain.model.HoroscopeSing.Acuario
import com.example.horoscopo.domain.model.HoroscopeSing.Aries
import com.example.horoscopo.domain.model.HoroscopeSing.Cancer
import com.example.horoscopo.domain.model.HoroscopeSing.Capricornio
import com.example.horoscopo.domain.model.HoroscopeSing.Escorpio
import com.example.horoscopo.domain.model.HoroscopeSing.Geminis
import com.example.horoscopo.domain.model.HoroscopeSing.Leo
import com.example.horoscopo.domain.model.HoroscopeSing.Libra
import com.example.horoscopo.domain.model.HoroscopeSing.Piscis
import com.example.horoscopo.domain.model.HoroscopeSing.Sagitario
import com.example.horoscopo.domain.model.HoroscopeSing.Tauro
import com.example.horoscopo.domain.model.HoroscopeSing.Virgo
import javax.inject.Inject

class HoroscopesProvider @Inject constructor() {

    fun getHoroscopes(): List<HoroscopeSing> {
        return listOf(
            Aries,
            Acuario,
            Capricornio,
            Cancer,
            Piscis,
            Sagitario,
            Tauro,
            Geminis,
            Libra,
            Escorpio,
            Leo,
            Virgo
        )
    }
}