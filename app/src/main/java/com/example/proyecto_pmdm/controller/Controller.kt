package com.example.proyecto_pmdm.controller

import android.content.Context
import android.widget.Toast
import com.example.proyecto_pmdm.MainActivity
import com.example.proyecto_pmdm.adapter.AdapterCancion
import com.example.proyecto_pmdm.dao.DaoCanciones
import com.example.proyecto_pmdm.models.Cancion

class Controller(val context: Context) {
    lateinit var listCanciones: MutableList<Cancion>

    init {
        initData()
    }

    private fun initData() {
        listCanciones = DaoCanciones.myDao.getDataHotels().toMutableList() // Llamamos al singleton.
    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listCanciones.forEach {
            println(it)
        }
    }

    fun setAdapter() {
        // Cargamos nuestro AdapterCancion al adapter del RecyclerView
        val myActivity = context as MainActivity
        myActivity.binding.myRecyclerView.adapter = AdapterCancion(listCanciones)
    }
}
