package com.example.todolist.confing

import android.app.Application
import com.example.todolist.repository.TodoRepository

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()

        TodoRepository.initialize(this)
    }
}