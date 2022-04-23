package com.example.ramadanreminder.RamdanDay.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ramadanreminder.Model.RamdanModel
import com.example.ramadanreminder.Repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpecificViewModel(var repo: Repo) : ViewModel() {
    private val dataMutable = MutableLiveData<RamdanModel>()

    var dataimmutable : LiveData<RamdanModel> =dataMutable

    fun inserttoDB(Model: RamdanModel){
        println("insert")

        viewModelScope.launch(Dispatchers.IO){
            repo.insertData(Model) } }


    fun getLocal(int: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            println("repo : $repo")
            val result=repo.getStoredData(int)
            println("insert : ${result.tasbih} , ${result.quran} , ${result.azkarM},${result.azkarS} , ${result.idday}")

            println("result: ${result.tasbih}" )

            withContext(Dispatchers.Main){
                dataMutable.postValue(result)
            }
        }
    }
}