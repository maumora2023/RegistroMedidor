
package com.example.registromedidor.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PagoRepository private constructor(private val pagoDao: PagoDao) {

    suspend fun agregarPago(pago: Pago) {
        withContext(Dispatchers.IO) {
            pagoDao.agregarPago(pago)
        }
    }

    companion object {
        @Volatile
        private var instance: PagoRepository? = null

        fun getInstance(pagoDao: PagoDao): PagoRepository {
            return instance ?: synchronized(this) {
                instance ?: PagoRepository(pagoDao).also { instance = it }
            }
        }
    }
}