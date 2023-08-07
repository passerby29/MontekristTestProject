package dev.passerby.montekristtestproject.domain.repository

import androidx.lifecycle.LiveData
import dev.passerby.montekristtestproject.domain.models.PlanetInfo

interface PlanetRepository {

    fun getPlanetInfoList(): LiveData<List<PlanetInfo>>

    fun getPlanetInfo(): LiveData<PlanetInfo>

    fun loadPlanetData()
}