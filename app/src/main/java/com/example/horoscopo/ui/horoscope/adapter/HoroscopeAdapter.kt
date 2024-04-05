package com.example.horoscopo.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.R
import com.example.horoscopo.domain.model.HoroscopeSing

class HoroscopeAdapter(
    private var list: List<HoroscopeSing> = emptyList(),
    private val onItemSelected: (HoroscopeSing) -> Unit
) : RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(list[position],onItemSelected)
    }

    fun updateList(newList: List<HoroscopeSing>) {
        list = newList
        notifyDataSetChanged()
    }
}