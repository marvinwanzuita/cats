package com.mawit.cats

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mawit.cats.dao.ImagemDao
import com.mawit.cats.model.Imagem

@Database(entities = [Imagem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imagemDao(): ImagemDao

    companion object {

        private const val DATABASE_NOME: String = "DB_IMAGEM"

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NOME
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}