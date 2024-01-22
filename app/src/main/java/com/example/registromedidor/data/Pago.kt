package com.example.registromedidor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pago_table")
data class Pago(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val monto: Double,
    val fecha: String,
    val tipo: String,
    val descripcion: String,

)