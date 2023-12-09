import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmdm.R
import com.example.proyecto_pmdm.models.Cancion

class DialogUpdateCancion(
    private val existingCancion: Cancion,
    private val onUpdateCancion: (Cancion) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_dialog_update_cancion, null)

        val txtTitle = view.findViewById<EditText>(R.id.editTextTitle)
        val txtArtist = view.findViewById<EditText>(R.id.editTextArtist)
        val txtGenre = view.findViewById<EditText>(R.id.editTextGenre)
        val txtDuration = view.findViewById<EditText>(R.id.editTextDuration)

        // Prepopulate the fields with existing data
        txtTitle.setText(existingCancion.title)
        txtArtist.setText(existingCancion.artist)
        txtGenre.setText(existingCancion.genre)
        txtDuration.setText(existingCancion.duration)

        builder.setView(view)
            .setPositiveButton("Actualizar", DialogInterface.OnClickListener { dialog, id ->
                val updatedCancion = Cancion(
                    txtTitle.text.toString(),
                    txtArtist.text.toString(),
                    txtGenre.text.toString(),
                    txtDuration.text.toString(),
                    existingCancion.imageURL
                )

                onUpdateCancion(updatedCancion)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        return builder.create()
    }
}
