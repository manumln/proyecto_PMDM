package com.example.proyecto_pmdm.objects_models

import com.example.proyecto_pmdm.models.Cancion

object Repository {
    val listCanciones: MutableList<Cancion> = mutableListOf(
        Cancion(
            "positions", "Ariana Grande", "Pop",
            "2:52", "https://upload.wikimedia.org/wikipedia/en/a/a0/Ariana_Grande_-_Positions.png"
            ),
        Cancion(
            "Feather", "Sabrina ", "Pop",
            "3:05", "https://m.media-amazon.com/images/I/71bZG4fuxzL._UF894,1000_QL80_.jpg"
        ),
        Cancion(
            "Movies", "Weyes Blood", "Indie",
            "5:53", "https://www.mindies.es/wp-content/uploads/2019/04/weyes-blood.jpg"
        ),
        Cancion(
            "Doin' time", "Lana Del Rey", "Indie",
            "3:22", "https://assets.primaverasound.com/psweb/t3f5kfy1hh7sw5h4ybf0_1616069563060.jpg"
        ),
        Cancion(
            "Cupido", "TINI", "Pop Latino",
            "2:54", "https://m.media-amazon.com/images/I/613k-Ix6J-L._UF894,1000_QL80_.jpg"
        ),
        Cancion(
            "Roller Coaster", "NMIXX", "K-Pop",
            "3:34", "https://upload.wikimedia.org/wikipedia/en/9/9b/Nmixx_-_Roller_Coaster.png"
        ),
        Cancion(
            "Kill Bill", "SZA", "R&B",
            "2:33", "https://upload.wikimedia.org/wikipedia/en/2/2c/SZA_-_S.O.S.png"
        ),
        Cancion(
            "Drama", "Aespa", "K-Pop",
            "3:34", "https://upload.wikimedia.org/wikipedia/commons/d/da/Aespa_-_Drama.png"
        )

    )
}