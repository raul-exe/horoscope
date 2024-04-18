package com.example.horoscopo.ui.lucky

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.horoscopo.R
import com.example.horoscopo.databinding.FragmentLuckyBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint
class LuckyFragment : Fragment() {

    private var _binding: FragmentLuckyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.ivCards.setOnClickListener{
            spinRoulette()
        }
    }

    private fun spinRoulette() {
        val spins = Random().nextInt(4)
        val degreesRotation = if(spins == 0) 360 else spins * 360
        val animator = ObjectAnimator.ofFloat(binding.ivCards,View.ROTATION,0f,degreesRotation.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard(){
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverseCard.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {
                growUpCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        binding.ivReverseCard.startAnimation(slideUpAnimation)
    }

    private fun growUpCard() {
        val growUpAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.grow_card)

        growUpAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivReverseCard.visibility = View.GONE
                transitionCards()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        binding.ivReverseCard.startAnimation(growUpAnimation)
    }

    private fun transitionCards(){
        val disappearCardsAnimation = AlphaAnimation(1f,0f)
        disappearCardsAnimation.duration = 200

        val appearPredictionAnimation = AlphaAnimation(0f,1f)
        appearPredictionAnimation.duration = 500

        disappearCardsAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        binding.preview.startAnimation(disappearCardsAnimation)
        binding.prediction.startAnimation(appearPredictionAnimation)
    }

}