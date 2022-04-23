package com.example.ramadanreminder.Repo

import com.example.ramadanreminder.DB.LocalSource
import com.example.ramadanreminder.Model.RamdanModel

class Repo ( var localSource: LocalSource):RepoInterface{

    companion object{
        private var repo: Repo? = null

        fun getInstance(localSource: LocalSource): Repo{
            return repo?:Repo(localSource)
        }

    }


    override suspend fun getStoredData(int: Int): RamdanModel {
        println("localSource $localSource")
        return localSource.getData(int)

    }

    override suspend fun insertData(ramdanModel: RamdanModel) {
        println("insert : ${ramdanModel.tasbih} , ${ramdanModel.quran} , ${ramdanModel.azkarM},${ramdanModel.azkarS} , ${ramdanModel.idday}")

        return localSource.insertData(ramdanModel)
    }
}