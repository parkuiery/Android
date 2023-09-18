package com.amazing.android.clickpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.amazing.android.clickpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var clickCount = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //binding.lifecycleOwner = this

        binding.clickBtn.setOnClickListener {
            viewModel.incrementCounter()
        }

        binding.start.setOnClickListener {
            viewModel.checkTime()
        }

        binding.set.setOnClickListener {
            viewModel.set()
        }

        viewModel.counter.observe(this) { count ->
            binding.clickCount.text = count.toString()
        }

        viewModel.time.observe(this) { time ->
            binding.time.text = time.toString()
        }

    }

}