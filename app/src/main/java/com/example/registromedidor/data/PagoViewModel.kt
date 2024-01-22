
package com.example.registromedidor.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PagoViewModel(private val pagoRepository: PagoRepository) : ViewModel() {

    fun agregarPago(pago: Pago) {
        viewModelScope.launch {
            pagoRepository.agregarPago(pago)
        }
    }
}


