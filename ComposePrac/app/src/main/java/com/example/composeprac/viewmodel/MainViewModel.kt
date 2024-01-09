package com.example.composeprac.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeprac.LoginState

class MainViewModel : ViewModel(){
    private val _loginState: MutableLiveData<LoginState> = MutableLiveData(LoginState())
    val loginState: LiveData<LoginState> = _loginState
    //val email : LiveData<LoginState> get() = loginState
    //val password : LiveData<LoginState> get() = loginState
    //val loginState : LiveData<LoginState> = _loginState

    fun updateEmail(email : String) {
        _loginState.postValue(loginState.value?.copy(email = email))
    }

    fun updatePassword(password : String) {
        _loginState.postValue(loginState.value?.copy(password = password))
    }


}