package com.example.multiplatformpractice.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multiplatformpractice.Greeting
import com.example.multiplatformpractice.Repository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SampleView()
                }
            }
        }
    }
}

@Composable
fun SampleView() {
    val repository = Repository()
    var savedString by remember { mutableStateOf(repository.getSavedString()) }

    LaunchedEffect(Unit) {
        repository.
    }

    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        item {
            EditS
        }
    }
}

@Composable
fun EditSavedString(savedString: String, onSavedString: (String) -> Unit) {
    var newString by remember {
        mutableStateOf(
            (savedString)
        )
    }
    Column {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Saved String",
            color = Color.DarkGray,
            fontSize = 24.sp
        )
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .height(56.dp),
            value = newString,
            onValueChange = { newString = it}
        )
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.LightGray),
            onClick = {}
        ) {
            
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
