package com.example.ramadanreminder.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ramadanreminder.Model.RamdanModel

@Database(entities = [RamdanModel::class], version = 13)
 abstract class AppDataBase :RoomDatabase() {

 abstract fun RamadanDAO(): RamdanDAO
 //singleton
 companion object{
  private var instance: AppDataBase? = null

  //one thread at a time to access this method
  @Synchronized
  fun getInstance(context: Context): AppDataBase?{
   return instance?: Room.databaseBuilder(
    context.applicationContext,AppDataBase::class.java,
    "Ramadan")
    .fallbackToDestructiveMigration()
    .build()
  }
 }

}