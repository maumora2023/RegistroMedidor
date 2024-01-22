package com.example.registromedidor.data

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.registromedidor.R

class FormularioMedicionActivity : AppCompatActivity() {

    private lateinit var pagoViewModel: PagoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        pagoViewModel = ViewModelProvider(this).get(PagoViewModel::class.java)

        val etFecha = findViewById<EditText>(R.id.etFecha)
        val etMedidor = findViewById<EditText>(R.id.etMedidor)
        val radioGroupTipoMedidor = findViewById<RadioGroup>(R.id.radioGroupTipoMedidor)
        val btnRegistrarMedicion = findViewById<Button>(R.id.btnRegistrarMedicion)


        btnRegistrarMedicion.setOnClickListener {
            val fecha = etFecha.text.toString()
            val medidor = etMedidor.text.toString().toDoubleOrNull() ?: -1.0
            val tipoMedidor = when (radioGroupTipoMedidor.checkedRadioButtonId) {
                R.id.radioAgua -> "Agua"
                R.id.radioLuz -> "Luz"
                R.id.radioGas -> "Gas"
                else -> ""
            }

            if (validarCampos(fecha, medidor, tipoMedidor)) {
                val nuevoPago = Pago(id = 0, monto = medidor, fecha = fecha, tipo = tipoMedidor, descripcion = "")
                pagoViewModel.agregarPago(nuevoPago)

                Toast.makeText(this, "Medición registrada exitosamente", Toast.LENGTH_SHORT).show()
                limpiarCampos()
            }
        }
    }

    private fun validarCampos(fecha: String, medidor: Double, tipoMedidor: String): Boolean {
        return if (fecha.isNotEmpty() && medidor >= 0 && tipoMedidor.isNotEmpty()) {
            true
        } else {
            Toast.makeText(this, "Completa todos los campos de manera válida", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun limpiarCampos() {
        findViewById<EditText>(R.id.etFecha).setText("")
        findViewById<EditText>(R.id.etMedidor).setText("")
        findViewById<RadioGroup>(R.id.radioGroupTipoMedidor).clearCheck()
    }
}
