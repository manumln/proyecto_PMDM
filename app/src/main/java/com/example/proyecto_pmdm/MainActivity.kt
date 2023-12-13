package com.example.proyecto_pmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_pmdm.controller.Controller
import com.example.proyecto_pmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var controller: Controller
    lateinit var binding: ActivityMainBinding

    // Elimina la función de acceso generada automáticamente con el nombre `<get-binding>`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
