package com.uiel.musicplayer.ui.playlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayListScreen(
    navigateUp: () -> Unit,
    playListId: Long,
    playListTitle: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick =  navigateUp ) {
                        Icon(
                            //painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                title = { Text(text = playListTitle) }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "플레이리스트 플레이리시트")
            Text(text = "플레이리스트 플레이리시트")
            Text(text = "플레이리스트 플레이리시트")
            Text(text = "플레이리스트 플레이리시트")
            Text(text = "플레이리스트 플레이리시트")

        }
    }
}