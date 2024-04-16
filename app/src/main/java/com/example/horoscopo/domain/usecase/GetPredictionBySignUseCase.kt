package com.example.horoscopo.domain.usecase

import com.example.horoscopo.domain.HoroscopeRepository
import javax.inject.Inject

class GetPredictionBySignUseCase @Inject constructor(private val repository: HoroscopeRepository) {
    suspend operator fun invoke(sing: String) = repository.getPrediction(sing)
}