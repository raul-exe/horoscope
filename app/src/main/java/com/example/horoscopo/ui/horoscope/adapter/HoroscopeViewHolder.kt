package com.example.horoscopo.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.databinding.ItemHoroscopeBinding
import com.example.horoscopo.domain.model.HoroscopeSing

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeSing: HoroscopeSing, onItemSelected: (HoroscopeSing) -> Unit){
        val context = binding.ivHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeSing.image)
        binding.tvName.text = context.getString(horoscopeSing.name)

        binding.parent.setOnClickListener {
            starRotationAnimation(binding.ivHoroscope){
                onItemSelected(horoscopeSing)
            }
        }
    }

    private fun starRotationAnimation(view: View, onClick: () -> Unit ){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { onClick() }
            start()
        }
    }
}