package dev.passerby.montekristtestproject.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.models.db.ApiFactory
import dev.passerby.montekristtestproject.data.database.AppDatabase
import dev.passerby.montekristtestproject.data.mapper.PlanetMapper
import dev.passerby.montekristtestproject.domain.models.PlanetInfo
import dev.passerby.montekristtestproject.domain.repository.PlanetRepository

class PlanetRepositoryImpl(application: Application) : PlanetRepository {

    private val planetInfoDao = AppDatabase.getInstance(application).planetInfoDao()
    private val apiService = ApiFactory.apiService
    private val planetMapper = PlanetMapper()
    private val TAG = "PlanetRepositoryImpl"

    override fun getPlanetInfoList(): LiveData<List<PlanetInfo>> {
        val planetInfoList = planetInfoDao.getPlanetInfoList()
        return planetInfoList.map { list ->
            list.map {
                planetMapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getPlanetInfo(name: String): LiveData<PlanetInfo> {
        return planetInfoDao.getPlanetInfo(name).map {
            planetMapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadPlanetData() {
        for (i in 1 until 61) {
            try {
                val planetInfoDto = apiService.getPlanetInfo(i)
                planetInfoDao.insertPlanetInfo(planetMapper.mapDtoToDbModel(planetInfoDto))
            } catch (e: Exception) {
                Log.d(TAG, "loadPlanetData: $e")
            }
        }
    }
}