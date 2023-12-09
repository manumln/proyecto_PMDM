import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmdm.R

class DialogDeleteCancion(
    private val position: Int,
    private val name: String,
    private val onDeleteCancionDialog: (Int) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setMessage("¿Deseas borrar la canción \"$name\"?")
            .setPositiveButton("Sí") { _, _ ->
                // Envía el evento del botón positivo de vuelta a la actividad principal
                onDeleteCancionDialog(position)
            }
            .setNegativeButton("No") { dialog, _ ->
                // Envía el evento del botón negativo de vuelta a la actividad principal
                dialog.dismiss()
            }
            .create()
    }
}
