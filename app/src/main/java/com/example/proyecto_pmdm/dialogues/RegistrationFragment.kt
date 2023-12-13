package com.example.proyecto_pmdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.Toast

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val registerButton: Button = view.findViewById(R.id.registerFragmentButton)

        registerButton.setOnClickListener {
            // Handle user registration logic here
            // For simplicity, you can just display a toast message
            Toast.makeText(requireContext(), "Registration logic goes here", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
