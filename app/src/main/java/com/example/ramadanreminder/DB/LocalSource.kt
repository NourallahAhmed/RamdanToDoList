package com.example.ramadanreminder.DB

import com.example.ramadanreminder.Model.RamdanModel

interface LocalSource {

    suspend fun insertData(ramdanModel: RamdanModel)
    suspend fun getData(int: Int) :RamdanModel

}