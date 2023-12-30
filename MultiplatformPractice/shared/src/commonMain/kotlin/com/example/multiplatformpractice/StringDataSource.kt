package com.example.multiplatformpractice

expect class StringDataSource() {

    fun getSavedString():String
    fun saveString(string: String)
}