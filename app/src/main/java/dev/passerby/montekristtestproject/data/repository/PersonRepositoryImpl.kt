package dev.passerby.montekristtestproject.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.models.db.ApiFactory
import dev.passerby.montekristtestproject.data.database.AppDatabase
import dev.passerby.montekristtestproject.data.mapper.PersonMapper
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class PersonRepositoryImpl(application: Application) : PersonRepository {

    private val personInfoDao = AppDatabase.getInstance(application).personInfoDao()
    private val apiService = ApiFactory.apiService
    private val personMapper = PersonMapper()
    private val tag = "PersonRepositoryImpl"

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

    override suspend fun loadPersonData() {
        try {
            val personInfoDtoList = apiService.getPersonInfo()
            val personDbModelList = personInfoDtoList.map { personMapper.mapDtoToDbModel(it) }
            personInfoDao.insertPersonInfoList(personDbModelList)
        } catch (e: Exception) {
            Log.d(tag, "loadPersonData: $e")
        }
    }
}