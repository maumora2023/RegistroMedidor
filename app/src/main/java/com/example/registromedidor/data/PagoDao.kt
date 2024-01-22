package com.example.registromedidor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PagoDao {
    @Insert
    suspend fun agregarPago(pago: Pago)

    @Query("SELECT * FROM pago_table")
    suspend fun getAllPagos(): List<Pago>
}