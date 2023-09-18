package com.amazing.android.clickpractice

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer
    private var isClick = false

    val counter = MutableLiveData<Int>().apply { value = 0 }
    val time = MutableLiveData<String>().apply { value = "0" }

    fun incrementCounter() {
        if (isClick) counter.value = (counter.value ?: 0) + 1
    }

    fun checkTime() {
        val countDownSeconds = 5

        countDownTimer = object : CountDownTimer((countDownSeconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000).toInt()
                time.value = secondsRemaining.toString()
                isClick = true
            }

            override fun onFinish() {
                isClick = false
            }
        }

        countDownTimer.start()

    }

    fun set() {
        counter.value = 0
    }
}