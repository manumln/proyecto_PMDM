package com.example.proyecto_pmdm.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.Cancion
import com.bumptech.glide.Glide

class ViewHCancion(view: View) : RecyclerView.ViewHolder(view) {
    private val txtviewTitle: TextView = view.findViewById(R.id.txtview_title)
    private val txtviewArtist: TextView = view.findViewById(R.id.txtview_artist)
    private val txtviewGenre: TextView = view.findViewById(R.id.txtview_genre)
    private val txtviewDuration: TextView = view.findViewById(R.id.txtview_duration)
    private val ivCancion: ImageView = view.findViewById(R.id.iv_cancion)
    val btnDelete: ImageView = view.findViewById(R.id.btn_delete)
    val btnUpdate: ImageView = view.findViewById(R.id.btn_edit)


    init {
        btnDelete.setOnClickListener {
        }
    }


    fun renderize(cancion: Cancion) {
        txtviewTitle.text = cancion.title
        txtviewArtist.text = cancion.artist
        txtviewGenre.text = cancion.genre
        txtviewDuration.text = cancion.duration

        Glide.with(itemView.context)
            .load(cancion.imageURL)
            .centerCrop()
            .into(ivCancion)
    }

}
