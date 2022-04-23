package com.example.ramadanreminder.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ramadanreminder.Model.RamdanModel

@Dao
interface RamdanDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(ramdanModel: RamdanModel) ;

    @Query("SELECT * FROM Ramadan WHERE idday= :ramdanday")
    fun getstoredDate(ramdanday: Int): RamdanModel? ;
}