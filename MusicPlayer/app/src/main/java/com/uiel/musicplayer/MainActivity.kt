@file:Suppress("UNUSED_EXPRESSION")

package com.uiel.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uiel.musicplayer.ui.home.HomeScreen
import com.uiel.musicplayer.ui.playlist.PlayListScreen
import com.uiel.musicplayer.ui.theme.MusicPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                MusicApp()
            }
        }
    }
}

@Composable
fun MusicApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                openPlayList = {
                    navController.navigate("play_list")
                },
            )
        }
        composable("play_list") {
            PlayListScreen(
                navigateUp = {
                    //navController.popBackStack()
                    navController::navigateUp
                },
            )
        }
    }
}
