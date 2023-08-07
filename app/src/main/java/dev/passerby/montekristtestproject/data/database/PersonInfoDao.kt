package dev.passerby.montekristtestproject.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.passerby.montekristtestproject.data.models.db.PersonInfoDbModel

@Dao
interface PersonInfoDao {

    @Query("select * from people")
    fun getPersonInfoList(): LiveData<List<PersonInfoDbModel>>

    @Query("select * from people where name = :name")
    fun getPersonInfo(name: String): LiveData<PersonInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersonInfoList(personInfoList: List<PersonInfoDbModel>)
}