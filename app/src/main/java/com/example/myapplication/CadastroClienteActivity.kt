package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CadastroClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        val nomeEditText: EditText = findViewById(R.id.nomeEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val telefoneEditText: EditText = findViewById(R.id.telefoneEditText)
        val cadastrarButton: Button = findViewById(R.id.cadastrarButton)

        cadastrarButton.setOnClickListener {
            // Salvar informações do cliente
            val cliente = Cliente(
                nomeEditText.text.toString(),
                emailEditText.text.toString(),
                telefoneEditText.text.toString()
            )
            ClienteRepository.cliente = cliente

            // Ir para a página de cadastro concluído
            val intent = Intent(this, CadastroConcluidoActivity::class.java)
            startActivity(intent)
        }
    }
}
