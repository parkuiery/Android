package com.example.multiplatformpractice

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform