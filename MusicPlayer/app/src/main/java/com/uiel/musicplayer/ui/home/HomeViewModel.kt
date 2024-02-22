package com.uiel.musicplayer.ui.home

import androidx.lifecycle.ViewModel
import com.uiel.musicplayer.data.music.MusicRepository
import com.uiel.musicplayer.data.music.PlayList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
): ViewModel() {
    fun fetchPlayLists() : List<PlayList> = musicRepository.fetchPlayList()
}