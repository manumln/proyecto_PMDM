package com.example.proyecto_pmdm

import RegistrationFragment
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class LoginActivity : AppCompatActivity() {

    private val MYUSER = "manumln"
    private val MYPASS = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val validarButton: Button = findViewById(R.id.validarButton)
        val headerImage: ImageView = findViewById(R.id.headerImage)
        val registerFragmentButton: Button = findViewById(R.id.registerFragmentButton)

        Glide.with(this)
            .asGif()
            .load(R.drawable.logo_gif)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .into(headerImage)

        validarButton.setOnClickListener {
            val inputUser = usernameEditText.text.toString()
            val inputPass = passwordEditText.text.toString()

            if (estaLogeado(inputUser, inputPass)) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("USERNAME", inputUser)
                intent.putExtra("PASSWORD", inputPass)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginActivity, "Usuario no registrado o Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        registerFragmentButton.setOnClickListener {
            showRegistrationDialog()
        }
    }

    private fun estaLogeado(user: String, pass: String): Boolean {
        return user == MYUSER && pass == MYPASS
    }

    // Método para mostrar el diálogo de registro
    private fun showRegistrationDialog() {
        val registrationDialog = RegistrationFragment()
        registrationDialog.show(supportFragmentManager, "RegistrationDialog")
    }
}
