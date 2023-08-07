package dev.passerby.montekristtestproject.domain.repository

import androidx.lifecycle.LiveData
import dev.passerby.montekristtestproject.domain.models.PersonInfo

interface PersonRepository {

    fun getPersonInfoList(): LiveData<List<PersonInfo>>

    fun getPersonInfo(name: String): LiveData<PersonInfo>

    suspend fun loadPersonData()
}