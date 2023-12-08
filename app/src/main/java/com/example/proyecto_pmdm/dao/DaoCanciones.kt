package com.example.proyecto_pmdm.dao

import com.example.proyecto_pmdm.models.Cancion
import com.example.proyecto_musica_pmdm.objects_models.Repository

interface InterfaceDao {
    fun getDataHotels(): List<Cancion>
}

class DaoCanciones private constructor() : InterfaceDao {
    companion object {
        val myDao: DaoCanciones by lazy {
            DaoCanciones()
        }
    }

    override fun getDataHotels(): List<Cancion> {
        return Repository.listCanciones
    }
}