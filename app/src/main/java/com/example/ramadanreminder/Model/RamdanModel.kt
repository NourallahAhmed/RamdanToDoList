package com.example.ramadanreminder.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ramadan")

data class RamdanModel(
    @PrimaryKey
    var idday : Int,
    var azkarS :Boolean,
    var azkarM :Boolean,
    var quran :Boolean,
    var tasbih :Boolean)