package dev.passerby.montekristtestproject.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import dev.passerby.montekristtestproject.Constants.TAG
import dev.passerby.montekristtestproject.data.database.AppDatabase
import dev.passerby.montekristtestproject.data.mapper.PersonMapper
import dev.passerby.montekristtestproject.data.network.ApiFactory
import dev.passerby.montekristtestproject.domain.models.PeopleSearch
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class PersonRepositoryImpl(application: Application) : PersonRepository {

    private val personInfoDao = AppDatabase.getInstance(application).personInfoDao()
    private val apiService = ApiFactory.apiService
    private val personMapper = PersonMapper()

    override fun getPersonInfoList(): LiveData<List<PersonInfo>> {
        val personInfoList = personInfoDao.getPersonInfoList()
        return personInfoList.map { list ->
            list.map {
                personMapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getPersonInfo(name: String): LiveData<PersonInfo> {
        return personInfoDao.getPersonInfo(name).map {
            personMapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun getPeopleSearch(searchParam: String): PeopleSearch {
        val peopleSearch = apiService.getPeopleSearch(searchParam)
        return personMapper.mapDtoToEntity(peopleSearch)
    }

    override suspend fun loadPersonData() {
        for (i in 1 until 83) {
            try {
                val personInfoDto = apiService.getPersonInfo(i)
                personInfoDao.insertPersonInfo(personMapper.mapDtoToDbModel(personInfoDto))
            } catch (e: Exception) {
                Log.d(TAG, "loadPersonData: $e $i")
            }
        }
    }
}