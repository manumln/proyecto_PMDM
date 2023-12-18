package com.example.proyecto_pmdm.dialogues

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.ArgumentsCancion
import com.example.proyecto_pmdm.models.Cancion

class DialogEditCancion(
    val cancionToUpdate: Cancion,
    val updateCancionDialog: (Cancion) -> Unit
) : DialogFragment() {

    val ARGUMENT_NAME: String = ArgumentsCancion.ARGUMENT_NAME
    val ARGUMENT_ARTIST: String = ArgumentsCancion.ARGUMENT_ARTIST
    val ARGUMENT_GENRE: String = ArgumentsCancion.ARGUMENT_GENRE
    val ARGUMENT_DURATION: String = ArgumentsCancion.ARGUMENT_DURATION
    val ARGUMENT_IMAGE: String = ArgumentsCancion.ARGUMENT_IMAGE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog_update_cancion, container, false)

        view.findViewById<EditText>(R.id.editTextTitle).setText(cancionToUpdate.title)
        view.findViewById<EditText>(R.id.editTextArtist).setText(cancionToUpdate.artist)
        view.findViewById<EditText>(R.id.editTextGenre).setText(cancionToUpdate.genre)
        view.findViewById<EditText>(R.id.editTextDuration).setText(cancionToUpdate.duration)
        view.findViewById<EditText>(R.id.editTextImageURL).setText(cancionToUpdate.imageURL)

        view.findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val updatedCancion = createUpdatedCancionFromInputs(view)
            if (validateInputs(updatedCancion)) {
                updateCancionDialog(updatedCancion)
                dismiss()
            } else {
                Toast.makeText(requireActivity(), "Algún campo está vacío", Toast.LENGTH_LONG).show()
            }
        }

        view.findViewById<Button>(R.id.buttonCancel).setOnClickListener {
            dismiss()
        }

        return view
    }

    private fun createUpdatedCancionFromInputs(view: View): Cancion {
        val editTextTitle = view.findViewById<EditText>(R.id.editTextTitle)
        val editTextArtist = view.findViewById<EditText>(R.id.editTextArtist)
        val editTextGenre = view.findViewById<EditText>(R.id.editTextGenre)
        val editTextDuration = view.findViewById<EditText>(R.id.editTextDuration)
        val editTextImageURL = view.findViewById<EditText>(R.id.editTextImageURL)

        return Cancion(
            editTextTitle.text.toString(),
            editTextArtist.text.toString(),
            editTextGenre.text.toString(),
            editTextDuration.text.toString(),
            editTextImageURL.text.toString()
        )
    }

    private fun validateInputs(cancion: Cancion): Boolean {
        return !cancion.title.isNullOrEmpty() &&
                !cancion.artist.isNullOrEmpty() &&
                !cancion.genre.isNullOrEmpty() &&
                !cancion.duration.isNullOrEmpty()
    }
}