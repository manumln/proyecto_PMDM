package com.example.proyecto_pmdm.dao

import com.example.proyecto_pmdm.models.Cancion
import com.example.proyecto_musica_pmdm.objects_models.Repository

class DaoCanciones private constructor() : InterfaceDao {
    companion object {
        val myDao: DaoCanciones by lazy {
            DaoCanciones()
        }
    }

    override fun getDataCanciones(): List<Cancion> {
        return Repository.listCanciones
    }
}