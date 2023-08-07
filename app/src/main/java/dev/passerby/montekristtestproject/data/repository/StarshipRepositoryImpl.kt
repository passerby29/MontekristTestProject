package dev.passerby.montekristtestproject.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.models.db.ApiFactory
import dev.passerby.montekristtestproject.data.database.AppDatabase
import dev.passerby.montekristtestproject.data.mapper.StarshipMapper
import dev.passerby.montekristtestproject.domain.models.StarshipInfo
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

    override suspend fun loadStarshipData() {
        try {
            val starshipInfoDtoList = apiService.getStarshipInfo()
            val starshipDbModelList = starshipInfoDtoList.map { starshipMapper.mapDtoToDbModel(it) }
            starshipInfoDao.insertStarshipInfoList(starshipDbModelList)
        } catch (e: Exception) {
            Log.d(TAG, "loadStarshipData: $e")
        }
    }

    companion object {
        private const val TAG = "StarshipRepositoryImpl"
    }
}