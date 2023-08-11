package dev.passerby.montekristtestproject.domain.repository

import androidx.lifecycle.LiveData
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.models.PeopleSearch

interface PersonRepository {

    fun getPersonInfoList(): LiveData<List<PersonInfo>>

    fun getPersonInfo(name: String): LiveData<PersonInfo>

    suspend fun getPeopleSearch(searchParam: String): PeopleSearch

    suspend fun loadPersonData()
}