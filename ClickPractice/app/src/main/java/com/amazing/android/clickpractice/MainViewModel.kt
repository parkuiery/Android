package com.amazing.android.clickpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val counter = MutableLiveData<Int>().apply { value = 0 }

    fun incrementCounter() {
        counter.value = (counter.value ?: 0) + 1
    }
}