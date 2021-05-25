package com.dicoding.moviecatalogue.utils

import com.airbnb.lottie.LottieAnimationView

object util{
    fun LottieAnimationView.setVisible(state: Boolean){
        if (state){
            visibility = LottieAnimationView.VISIBLE
        }else{
            visibility = LottieAnimationView.GONE
        }
    }

}