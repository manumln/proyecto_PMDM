package com.example.proyecto_pmdm.controller

import DialogDeleteCancion
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_pmdm.MainActivity
import com.example.proyecto_pmdm.adapter.AdapterCancion
import com.example.proyecto_pmdm.dao.DaoCanciones
import com.example.proyecto_pmdm.dialogues.DialogAddCancion
import com.example.proyecto_pmdm.dialogues.DialogEditCancion
import com.example.proyecto_pmdm.models.Cancion

class Controller(val context: Context) {
    private lateinit var myActivity: MainActivity
    private lateinit var listCanciones: MutableList<Cancion>
    private lateinit var adapterCancion: AdapterCancion
    private lateinit var layoutManager: LinearLayoutManager

    init {
        initData()
        setAdapter()
        initOnClickListener()
    }

    private fun initData() {
        listCanciones = DaoCanciones.myDao.getDataCanciones().toMutableList()
    }

    fun setAdapter() {
        myActivity = context as MainActivity
        adapterCancion = AdapterCancion(
            listCanciones,
            { pos -> delCancion(pos) },
            { pos -> updateCancion(pos) }
        )
        myActivity.binding.myRecyclerView.adapter = adapterCancion
        layoutManager = LinearLayoutManager(context)
        myActivity.binding.myRecyclerView.layoutManager = layoutManager
    }

    private fun delCancion(position: Int) {
        println("Borrando cancion $position")
        val dialog = DialogDeleteCancion(
            position,
            listCanciones[position].title
        ) { pos ->
            println("Confirma borrar la cancion $pos")
            okOnDeleteCancion(pos)
            showToast("Se eliminó la canción: ${listCanciones[pos].title}")
        }
        dialog.show((context as FragmentActivity).supportFragmentManager, "DeleteCancionDialog")
    }

    private fun okOnDeleteCancion(pos: Int) {
        val removedTitle = listCanciones[pos].title
        listCanciones.removeAt(pos)
        adapterCancion.notifyItemRemoved(pos)
        showToast("Se eliminó la canción: $removedTitle")

        println("Lista después de borrar: $listCanciones")
    }

    private fun addCancion() {
        Toast.makeText(context, "Añadiremos una nueva canción", Toast.LENGTH_LONG).show()
        val dialog = DialogAddCancion { cancion -> okOnNewCancion(cancion) }
        dialog.show((context as FragmentActivity).supportFragmentManager, "Añadimos una nueva canción")
    }

    private fun okOnNewCancion(cancion: Cancion) {
        listCanciones.add(listCanciones.size, cancion)
        adapterCancion.notifyItemInserted(listCanciones.lastIndex)
        layoutManager.scrollToPositionWithOffset(listCanciones.lastIndex, 20)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun updateCancion(position: Int) {
        if (position in 0 until listCanciones.size) {
            val existingCancion = listCanciones[position]

            val dialog = DialogEditCancion(existingCancion) { updatedCancion ->
                listCanciones[position] = updatedCancion
                adapterCancion.notifyItemChanged(position)
                showToast("Se actualizó la canción: ${updatedCancion.title}")
            }

            dialog.show((context as FragmentActivity).supportFragmentManager, "EditarCancionDialog")
        }
    }

    private fun initOnClickListener() {
        myActivity.binding.btnAdd.setOnClickListener {
            addCancion()
        }
    }
}
