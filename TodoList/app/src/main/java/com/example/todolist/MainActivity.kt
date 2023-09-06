package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.dto.Todo
import com.example.todolist.viewmodel.TodoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var todoViewModel: TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, EditTodoActivity::class.java).apply {
                putExtra("type","ADD")
            }
            requestActivity.launch(intent)
        }

        todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
    }

    private val requestActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK) {
            val todo = it.data?.getSerializableExtra("todo") as Todo

            when(it.data?.getIntExtra("flag",-1)) {
                0 -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        todoViewModel.insert(todo)
                    }
                    Toast.makeText(this, "추가되었습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


