package com.example.ramadanreminder.DB

import android.content.Context
import com.example.ramadanreminder.Model.RamdanModel

class ConcreteLocalSource(var context :Context) :LocalSource {
   private val ramdanDAO : RamdanDAO?

    init {
        val db1: AppDataBase? = AppDataBase.getInstance(context)
        ramdanDAO = db1!!.RamadanDAO()

    }

    override suspend fun insertData(ramdanModel: RamdanModel) {
        println("insert")

        ramdanDAO?.insertData(ramdanModel)

    }

    override suspend fun getData(int: Int) :RamdanModel {
        println("ramadanDao $ramdanDAO")
        return  ramdanDAO?.getstoredDate(int)!!
    }

}