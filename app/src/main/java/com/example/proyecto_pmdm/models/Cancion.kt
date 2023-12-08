package com.example.proyecto_pmdm.models

class Cancion(
    val title: String,
    val artist: String,
    val album: String,
    val genre: String,
    val duration: String,
    val imageURL: String
) {
    override fun toString(): String {
        return "Cancion(title='$title', artist='$artist', album='$album', genre='$genre', duration='$duration')"
    }
}