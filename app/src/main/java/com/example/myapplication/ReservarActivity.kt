package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import java.text.SimpleDateFormat
import java.util.*

class ReservarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservar)

        val carSpinner: Spinner = findViewById(R.id.carSpinner)
        val carList = listOf("VW Brasília", "VW Gol", "VW Fusca", "Ferrari 488 GTB", "Dodge Charger", "Subaru Impreza")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        carSpinner.adapter = adapter

        val dataRetiradaEditText: EditText = findViewById(R.id.dataRetiradaEditText)
        val dataDevolucaoEditText: EditText = findViewById(R.id.dataDevolucaoEditText)

        dataRetiradaEditText.setOnClickListener {
            showDatePicker(dataRetiradaEditText)
        }

        dataDevolucaoEditText.setOnClickListener {
            showDatePicker(dataDevolucaoEditText)
        }

        val reserveButton: Button = findViewById(R.id.reserveButton)
        reserveButton.setOnClickListener {
            // Validações de entrada e lógica de reserva

            val intent = Intent(this, ReservaConcluidaActivity::class.java)
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, CarOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                editText.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        // Define a data mínima como a data atual
        datePicker.datePicker.minDate = System.currentTimeMillis() - 1000
        datePicker.show()
    }
}
