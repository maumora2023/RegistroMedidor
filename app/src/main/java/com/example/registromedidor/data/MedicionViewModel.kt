package com.example.registromedidor.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicionViewModel : ViewModel() {
    private val _mediciones = MutableLiveData<List<RegistroMedicion>>()

    fun guardarMedicion(medicion: RegistroMedicion) {
        _mediciones.value = (_mediciones.value ?: emptyList()) + listOf(medicion)
    }
}