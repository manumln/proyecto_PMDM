package com.example.proyecto_pmdm.models

data class Cancion(
    val title: String,
    val artist: String,
    val genre: String,
    val duration: String,
    val imageURL: String? = null
){
    override fun toString(): String {
        return "Cancion(title='$title', artist='$artist', genre='$genre', duration='$duration')"
    }
}