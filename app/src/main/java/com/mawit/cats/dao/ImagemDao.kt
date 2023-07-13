package com.mawit.cats.dao

import androidx.room.Dao
import androidx.room.Insert
import com.mawit.cats.model.Imagem

@Dao
interface ImagemDao {

    @Insert
    fun inserir(listaImagens: MutableList<Imagem>)

}