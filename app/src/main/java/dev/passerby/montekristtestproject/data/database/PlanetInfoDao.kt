package dev.passerby.montekristtestproject.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.passerby.montekristtestproject.data.models.db.PlanetInfoDbModel

@Dao
interface PlanetInfoDao {

    @Query("select * from planets")
    fun getPlanetInfoList(): LiveData<List<PlanetInfoDbModel>>

    @Query("select * from people where name = :name")
    fun getPlanetInfo(name: String): LiveData<PlanetInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanetInfoList(planetInfoList: List<PlanetInfoDbModel>)
}