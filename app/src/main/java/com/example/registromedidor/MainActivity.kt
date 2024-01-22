package com.example.registromedidor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.registromedidor.data.MedicionViewModel
import com.example.registromedidor.data.RegistroMedicion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
    }


    class FormularioMedicionActivity : AppCompatActivity() {

        private lateinit var viewModel: MedicionViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_formulario)

            viewModel = ViewModelProvider(this).get(MedicionViewModel::class.java)

            val etFecha = findViewById<EditText>(R.id.etFecha)
            val etMedidor = findViewById<EditText>(R.id.etMedidor)
            val radioGroupTipoMedidor = findViewById<RadioGroup>(R.id.radioGroupTipoMedidor)
            val btnRegistrarMedicion = findViewById<Button>(R.id.btnRegistrarMedicion)

            btnRegistrarMedicion.setOnClickListener {
                val fecha = etFecha.text.toString()
                val medidor = etMedidor.text.toString()
                val tipoMedidor = when (radioGroupTipoMedidor.checkedRadioButtonId) {
                    R.id.radioAgua -> "Agua"
                    R.id.radioLuz -> "Luz"
                    R.id.radioGas -> "Gas"
                    else -> ""
                }

                if (fecha.isNotEmpty() && medidor.isNotEmpty() && tipoMedidor.isNotEmpty()) {
                    val nuevaMedicion = RegistroMedicion(tipoMedidor, medidor.toDouble(), fecha)
                    viewModel.guardarMedicion(nuevaMedicion)

                } else {

                    Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}