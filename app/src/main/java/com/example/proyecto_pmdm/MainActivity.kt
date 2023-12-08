package com.example.proyecto_pmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_pmdm.controller.Controller
import com.example.proyecto_pmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var controller: Controller
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init() // inicializo la clase
    }

    private fun init() {
        initRecyclerView()
        controller = Controller(this) // Creamos el controlador
        controller.setAdapter()
        // controller.loggOut() // Muestro el log en pantalla
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
