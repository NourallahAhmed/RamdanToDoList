package com.example.ramadanreminder.RamdanDay.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ramadanreminder.Repo.Repo

class SpecificViewModelFactory(var repo: Repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SpecificViewModel::class.java))
        {
            SpecificViewModel(repo) as T
        }
        else{
            throw IllegalAccessException("not Found")
        }
    }
}