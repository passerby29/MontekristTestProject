package dev.passerby.montekristtestproject.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.passerby.montekristtestproject.data.models.db.StarshipInfoDbModel

@Dao
interface StarshipInfoDao {

    @Query("select * from starships")
    fun getStarshipInfoList(): LiveData<List<StarshipInfoDbModel>>

    @Query("select * from starships where name = :name")
    fun getStarshipInfo(name: String): LiveData<StarshipInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStarshipInfo(starshipInfo: StarshipInfoDbModel)
}