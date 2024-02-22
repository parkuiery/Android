package com.uiel.musicplayer.data.music

data class PlayList(
    val id: Long,
    val title: String,
    val madeBy: String,
)

val dummyPlayList = listOf(
    PlayList(
        id = 1,
        title = "내 손을 잡아",
        madeBy = "IU",
    ),
    PlayList(
        id = 2,
        title = "I Love You",
        madeBy = "악뮤",
    ),
    PlayList(
        id = 3,
        title = "사랑 없는 노래",
        madeBy = "이구이",
    ),
    PlayList(
        id = 4,
        title = "다시 여기 바닷가",
        madeBy = "싹쓰리",
    ),
)