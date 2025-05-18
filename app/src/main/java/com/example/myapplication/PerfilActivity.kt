package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val cliente = ClienteRepository.cliente

        if (cliente != null) {
            val nomeTextView: TextView = findViewById(R.id.nomeTextView)
            val emailTextView: TextView = findViewById(R.id.emailTextView)
            val telefoneTextView: TextView = findViewById(R.id.telefoneTextView)

            nomeTextView.text = "Nome: ${cliente.nome}"
            emailTextView.text = "Email: ${cliente.email}"
            telefoneTextView.text = "Telefone: ${cliente.telefone}"
        }


    }
}
