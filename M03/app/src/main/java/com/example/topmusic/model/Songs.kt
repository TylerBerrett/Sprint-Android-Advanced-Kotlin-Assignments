package com.example.topmusic.model

sealed class Songs(val title: String, val artist: String){

    class Rap(title: String, artist: String): Songs(title, artist)
    class Pop(title: String, artist: String): Songs(title, artist)
    class Rock(title: String, artist: String): Songs(title, artist)
    class Latin(title: String, artist: String): Songs(title, artist)


}