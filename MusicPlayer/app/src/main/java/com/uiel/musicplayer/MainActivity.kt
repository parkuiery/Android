@file:Suppress("UNUSED_EXPRESSION")

package com.uiel.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uiel.musicplayer.ui.home.HomeScreen
import com.uiel.musicplayer.ui.music.MusicScreen
import com.uiel.musicplayer.ui.playlist.PlayListScreen
import com.uiel.musicplayer.ui.theme.MusicPlayerTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false,
        ),
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            MusicScreen(
                onHideCurrentPlayingModal = {
                    scope.launch {
                        scaffoldState.bottomSheetState.hide()
                    }
                },
            )
        },
        sheetDragHandle = null,
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") {
                HomeScreen(
                    openPlayList = {
                        navController.navigate("play_list")
                    },
                    onShowCurrentPlayingModal = {
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
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

}
