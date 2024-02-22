package com.uiel.musicplayer.data.music

import javax.inject.Inject

abstract class MusicRepository {
    abstract fun fetchPlayList(): List<PlayList>
}

class MusicRepositoryImpl @Inject constructor(): MusicRepository() {
    override fun fetchPlayList(): List<PlayList> = dummyPlayList
}
