package com.example.horoscopo.ui.horoscopedetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopo.R
import com.example.horoscopo.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscopo.domain.model.HoroscopeType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val viewmodel:HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        viewmodel.getPredictionBySign(args.type)
    }

    private fun initUI() {
        initListeners()
        initState()
    }

    private fun initListeners() {
        binding.ibBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewmodel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> onLoadingState()
                        is HoroscopeDetailState.Error -> onErrorState()
                        is HoroscopeDetailState.Success -> onSuccesState(it)
                    }
                }
            }
        }
    }

    private fun onSuccesState(state:HoroscopeDetailState.Success) {
        binding.progressbar.isVisible = false
        binding.tvErrorMessage.isVisible = false
        binding.tvHoroscopeName.text = state.data.singName
        binding.tvHoroscopeBody.text = state.data.horoscopeDescription

        val image = when(state.horoscopeType){
            HoroscopeType.Acuario -> R.drawable.acuario
            HoroscopeType.Aries -> R.drawable.aries
            HoroscopeType.Cancer -> R.drawable.cancer
            HoroscopeType.Capricornio -> R.drawable.capricornio
            HoroscopeType.Geminis -> R.drawable.geminis
            HoroscopeType.Leo -> R.drawable.leo
            HoroscopeType.Libra -> R.drawable.libra
            HoroscopeType.Piscis -> R.drawable.piscis
            HoroscopeType.Sagitario -> R.drawable.sagitario
            HoroscopeType.Escorpio -> R.drawable.escorpio
            HoroscopeType.Tauro -> R.drawable.tauro
            HoroscopeType.Virgo -> R.drawable.virgo
        }

        binding.ivHoroscope.setImageResource(image)
    }

    private fun onErrorState() {
        binding.progressbar.isVisible = false
        binding.tvErrorMessage.isVisible = true
    }

    private fun onLoadingState() {
        binding.tvErrorMessage.isVisible = false
        binding.progressbar.isVisible = true
    }


}