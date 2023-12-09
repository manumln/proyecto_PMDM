package com.example.proyecto_pmdm.controller

import DialogInsertCancion
import DialogUpdateCancion
import android.content.Context
import android.widget.Toast
import com.example.proyecto_pmdm.MainActivity
import com.example.proyecto_pmdm.adapter.AdapterCancion
import com.example.proyecto_pmdm.dao.DaoCanciones
import com.example.proyecto_pmdm.models.Cancion

class Controller(val context: Context) {
    lateinit var listCanciones: MutableList<Cancion>
    lateinit var adapterCancion: AdapterCancion // Agrega esta línea

    init {
        initData()
    }

    private fun initData() {
        listCanciones = DaoCanciones.myDao.getDataCanciones().toMutableList()
    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listCanciones.forEach {
            println(it)
        }
    }

    fun setAdapter() {
        val myActivity = context as MainActivity
        adapterCancion = AdapterCancion(
            listCanciones,
            { pos -> delCancion(pos) },
            { pos -> updateCancion(pos) }
        )
        myActivity.binding.myRecyclerView.adapter = adapterCancion
    }
    fun updateCancion(position: Int) {
        if (position in 0 until listCanciones.size) {
            val existingCancion = listCanciones[position]

            val dialog = DialogUpdateCancion(existingCancion) { updatedCancion ->
                // Actualiza la canción en la lista
                listCanciones[position] = updatedCancion

                adapterCancion.notifyItemChanged(position)

                showToast("Se actualizó la canción: ${updatedCancion.title}")
            }

            val myActivity = context as MainActivity
            dialog.show(myActivity.supportFragmentManager, "Editar canción")
        }
    }
    fun delCancion(position: Int) {
        // Verifica si la posición es válida
        if (position in 0 until listCanciones.size) {
            val deletedCancion = listCanciones[position]

            listCanciones.removeAt(position)

            adapterCancion.notifyItemRemoved(position)

            showToast("Se eliminó la canción: ${deletedCancion.title}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun addCancion() {
        val dialog = DialogInsertCancion { cancion ->
            // Logic for adding the song
            listCanciones.add(listCanciones.size, cancion)
            adapterCancion.notifyItemInserted(listCanciones.lastIndex)
        }

        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Añadir nueva canción")
    }
}
