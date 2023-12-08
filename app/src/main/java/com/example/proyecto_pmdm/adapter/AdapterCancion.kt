package com.example.proyecto_pmdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.Cancion

class AdapterCancion(var listCanciones: MutableList<Cancion>) : RecyclerView.Adapter<ViewHCancion>() {
    /*
     Método que crea la vista del ViewHolderCancion
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHCancion {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemCancion = R.layout.myrecycledview
        return ViewHCancion(layoutInflater.inflate(layoutItemCancion, parent, false))
    }

    /*
     Este método debe renderizar todos los datos o propiedades de cada canción con la vista.
     Accedemos al objeto por medio de la posición.
     */
    override fun onBindViewHolder(holder: ViewHCancion, position: Int) {
        holder.renderize(listCanciones[position]) // Renderizamos la vista.
    }

    /*
     Este método devuelve el número de objetos a representar en el RecyclerView.
     */
    override fun getItemCount(): Int = listCanciones.size
}