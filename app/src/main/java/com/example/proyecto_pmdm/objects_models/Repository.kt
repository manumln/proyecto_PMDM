package com.example.proyecto_musica_pmdm.objects_models

import com.example.proyecto_pmdm.models.Cancion

object Repository {
    val listCanciones: List<Cancion> = listOf(
        Cancion(
            "Houdini", "Dua Lipa", "Pop",
            "3:06", "https://upload.wikimedia.org/wikipedia/en/a/a0/Dua_Lipa_-_Houdini.png"
            ),
        Cancion(
            "Feather", "Sabrina ", "Pop",
            "3:05", "https://m.media-amazon.com/images/I/71bZG4fuxzL._UF894,1000_QL80_.jpg"
        ),
        Cancion(
            "Movies", "Weyes Blood", "Rock",
            "5:53", "https://www.mindies.es/wp-content/uploads/2019/04/weyes-blood.jpg"
        ),
        Cancion(
            "Drama", "Aespa", "Drama",
            "3:34", "https://upload.wikimedia.org/wikipedia/commons/d/da/Aespa_-_Drama.png"
        )
    )
}