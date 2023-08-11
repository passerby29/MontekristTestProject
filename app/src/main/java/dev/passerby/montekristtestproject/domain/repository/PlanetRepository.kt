package dev.passerby.montekristtestproject.domain.repository

import androidx.lifecycle.LiveData
import dev.passerby.montekristtestproject.domain.models.PlanetInfo
import dev.passerby.montekristtestproject.domain.models.PlanetsSearch

interface PlanetRepository {

    fun getPlanetInfoList(): LiveData<List<PlanetInfo>>

    fun getPlanetInfo(name: String): LiveData<PlanetInfo>

    suspend fun getPlanetSearch(searchParam: String): PlanetsSearch

    suspend fun loadPlanetData()
}