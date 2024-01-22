
package com.example.registromedidor.data

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    companion object {
        lateinit var database: PagoDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            PagoDatabase::class.java,
            "gasto_database"
        ).build()
    }
}
