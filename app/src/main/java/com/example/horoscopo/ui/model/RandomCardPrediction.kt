package com.example.horoscopo.ui.model

import com.example.horoscopo.R
import javax.inject.Inject
import kotlin.random.Random

class RandomCardPrediction @Inject constructor() {

    fun getLuckyCard(): LuckyModel? {
        return when (Random.nextInt(0, 32)) {
            1 -> LuckyModel(R.drawable.king_card, R.string.prediction_1)
            2 -> LuckyModel(R.drawable.king_card, R.string.prediction_2)
            3 -> LuckyModel(R.drawable.king_card, R.string.prediction_3)
            4 -> LuckyModel(R.drawable.king_card, R.string.prediction_4)
            5 -> LuckyModel(R.drawable.king_card, R.string.prediction_5)
            6 -> LuckyModel(R.drawable.king_card, R.string.prediction_6)
            7 -> LuckyModel(R.drawable.king_card, R.string.prediction_7)
            8 -> LuckyModel(R.drawable.king_card, R.string.prediction_8)
            9 -> LuckyModel(R.drawable.king_card, R.string.prediction_9)
            10 -> LuckyModel(R.drawable.king_card, R.string.prediction_10)
            11 -> LuckyModel(R.drawable.king_card, R.string.prediction_11)
            12 -> LuckyModel(R.drawable.king_card, R.string.prediction_12)
            13 -> LuckyModel(R.drawable.king_card, R.string.prediction_13)
            14 -> LuckyModel(R.drawable.king_card, R.string.prediction_14)
            15 -> LuckyModel(R.drawable.king_card, R.string.prediction_15)
            16 -> LuckyModel(R.drawable.king_card, R.string.prediction_16)
            17 -> LuckyModel(R.drawable.king_card, R.string.prediction_17)
            18 -> LuckyModel(R.drawable.king_card, R.string.prediction_18)
            19 -> LuckyModel(R.drawable.king_card, R.string.prediction_19)
            20 -> LuckyModel(R.drawable.king_card, R.string.prediction_20)
            21 -> LuckyModel(R.drawable.king_card, R.string.prediction_21)
            22 -> LuckyModel(R.drawable.king_card, R.string.prediction_22)
            23 -> LuckyModel(R.drawable.king_card, R.string.prediction_23)
            24 -> LuckyModel(R.drawable.king_card, R.string.prediction_24)
            25 -> LuckyModel(R.drawable.king_card, R.string.prediction_25)
            26 -> LuckyModel(R.drawable.king_card, R.string.prediction_26)
            27 -> LuckyModel(R.drawable.king_card, R.string.prediction_27)
            28 -> LuckyModel(R.drawable.king_card, R.string.prediction_28)
            29 -> LuckyModel(R.drawable.king_card, R.string.prediction_29)
            30 -> LuckyModel(R.drawable.king_card, R.string.prediction_30)
            31 -> LuckyModel(R.drawable.king_card, R.string.prediction_31)
            else -> null
        }
    }
}