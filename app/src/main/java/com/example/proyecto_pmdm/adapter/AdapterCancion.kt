package com.example.proyecto_pmdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.Cancion

class AdapterCancion(
    var listCanciones: MutableList<Cancion>,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: (Int) -> Unit
) : RecyclerView.Adapter<ViewHCancion>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHCancion {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemCancion = R.layout.myrecycledview
        return ViewHCancion(
            layoutInflater.inflate(layoutItemCancion, parent, false),
            deleteOnClick,
            updateOnClick
        )
    }

    override fun onBindViewHolder(holder: ViewHCancion, position: Int) {
        val cancion = listCanciones[position]
        holder.renderize(cancion)

        holder.btnUpdate.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION && adapterPosition < listCanciones.size) {
                updateOnClick(adapterPosition)
            }
        }

        holder.btnDelete.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION && adapterPosition < listCanciones.size) {
                deleteOnClick(adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int = listCanciones.size
}
