package com.example.ramadanreminder.Repo

import com.example.ramadanreminder.Model.RamdanModel

interface RepoInterface {
    suspend fun getStoredData(int: Int): RamdanModel
    suspend fun insertData(ramdanModel: RamdanModel)

}