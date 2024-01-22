
package com.example.registromedidor.data


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Pago::class], version = 1, exportSchema = false)
abstract class PagoDatabase : RoomDatabase() {
    abstract fun pagoDao(): PagoDao
}