package com.mawit.cats.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_imagem")
data class Imagem(

    @ColumnInfo(name = "id_url")
    val idUrl: Int,

    @ColumnInfo(name = "url")
    val url: String
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
