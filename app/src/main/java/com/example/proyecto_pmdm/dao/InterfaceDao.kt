package com.example.proyecto_pmdm.dao

import com.example.proyecto_pmdm.models.Cancion

interface InterfaceDao {
    fun getDataCanciones(): List<Cancion>
}