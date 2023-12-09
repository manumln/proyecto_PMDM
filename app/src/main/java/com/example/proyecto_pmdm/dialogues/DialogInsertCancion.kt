import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.Cancion

class DialogInsertCancion(private val onInsertCancionDialog: (Cancion) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_dialog_insert_cancion, null)

        val txtTitle = view.findViewById<EditText>(R.id.editTextTitle)
        val txtArtist = view.findViewById<EditText>(R.id.editTextArtist)
        val txtGenre = view.findViewById<EditText>(R.id.editTextGenre)
        val txtDuration = view.findViewById<EditText>(R.id.editTextDuration)

        builder.setView(view)
            .setPositiveButton("Añadir", DialogInterface.OnClickListener { dialog, id ->
                val newCancion = Cancion(
                    txtTitle.text.toString(),
                    txtArtist.text.toString(),
                    txtGenre.text.toString(),
                    txtDuration.text.toString()
                )

                if (newCancion.title.isNullOrEmpty() ||
                    newCancion.artist.isNullOrEmpty() ||
                    newCancion.genre.isNullOrEmpty() ||
                    newCancion.duration.isNullOrEmpty()
                ) {
                    Toast.makeText(activity, "Algún campo está vacío", Toast.LENGTH_LONG).show()
                    dialog.cancel()
                } else {
                    onInsertCancionDialog(newCancion)
                }
            })

        return builder.create()
    }
}
