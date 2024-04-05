package com.example.horoscopo.domain.model

import com.example.horoscopo.R

sealed class HoroscopeSing(val image: Int, val name:Int, val type:HoroscopeType) {
    data object Aries : HoroscopeSing(R.drawable.aries,R.string.sign_aries,HoroscopeType.Aries)
    data object Acuario : HoroscopeSing(R.drawable.acuario,R.string.sign_acuario,HoroscopeType.Acuario)
    data object Cancer : HoroscopeSing(R.drawable.cancer,R.string.sign_cancer,HoroscopeType.Cancer)
    data object Escorpio : HoroscopeSing(R.drawable.escorpio,R.string.sign_escorpio,HoroscopeType.Escorpio)
    data object Capricornio : HoroscopeSing(R.drawable.capricornio,R.string.sign_capricornio, HoroscopeType.Capricornio)
    data object Geminis : HoroscopeSing(R.drawable.geminis,R.string.sign_geminis,HoroscopeType.Geminis)
    data object Leo : HoroscopeSing(R.drawable.leo,R.string.sign_leo,HoroscopeType.Leo)
    data object Libra : HoroscopeSing(R.drawable.libra,R.string.sign_libra,HoroscopeType.Libra)
    data object Piscis : HoroscopeSing(R.drawable.piscis,R.string.sign_piscis,HoroscopeType.Piscis)
    data object Sagitario : HoroscopeSing(R.drawable.sagitario,R.string.sign_sagitario,HoroscopeType.Sagitario)
    data object Tauro : HoroscopeSing(R.drawable.tauro,R.string.sign_tauro,HoroscopeType.Tauro)
    data object Virgo : HoroscopeSing(R.drawable.virgo,R.string.sign_virgo,HoroscopeType.Virgo)
}