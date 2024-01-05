package com.example.composeprac.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val _email: MutableLiveData<String> = MutableLiveData()
    val email : LiveData<String> get() = _email

    fun updateEmail(email : String) {
        _email.postValue(email)
    }


}