package dev.passerby.montekristtestproject.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import dev.passerby.montekristtestproject.Constants.TAG
import dev.passerby.montekristtestproject.data.database.AppDatabase
import dev.passerby.montekristtestproject.data.mapper.StarshipMapper
import dev.passerby.montekristtestproject.data.network.ApiFactory
import dev.passerby.montekristtestproject.domain.models.StarshipInfo
import dev.passerby.montekristtestproject.domain.models.StarshipsSearch
import dev.passerby.montekristtestproject.domain.repository.StarshipRepository

class StarshipRepositoryImpl(application: Application) : StarshipRepository {

    private val starshipInfoDao = AppDatabase.getInstance(application).starshipInfoDao()
    private val apiService = ApiFactory.apiService
    private val starshipMapper = StarshipMapper()

    override fun getStarshipInfoList(): LiveData<List<StarshipInfo>> {
        val starshipInfoList = starshipInfoDao.getStarshipInfoList()
        return starshipInfoList.map { list ->
            list.map {
                starshipMapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getStarshipInfo(name: String): LiveData<StarshipInfo> {
        return starshipInfoDao.getStarshipInfo(name).map {
            starshipMapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun getStarshipsSearch(searchParam: String): StarshipsSearch {
        val starshipsSearch = apiService.getStarshipsSearch(searchParam)
        return starshipMapper.mapDtoToEntity(starshipsSearch)
    }

    override suspend fun loadStarshipData() {
        for (i in 1 until 37) {
            try {
                val starshipInfoDto = apiService.getStarshipInfo(i)
                starshipInfoDao.insertStarshipInfo(starshipMapper.mapDtoToDbModel(starshipInfoDto))
            } catch (e: Exception) {
                Log.d(TAG, "loadStarshipData: $e")
            }
        }
    }
}