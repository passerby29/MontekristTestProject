package dev.passerby.montekristtestproject.domain.repository

import androidx.lifecycle.LiveData
import dev.passerby.montekristtestproject.domain.models.StarshipInfo
import dev.passerby.montekristtestproject.domain.models.StarshipsSearch

interface StarshipRepository {

    fun getStarshipInfoList(): LiveData<List<StarshipInfo>>

    fun getStarshipInfo(name: String): LiveData<StarshipInfo>

    suspend fun getStarshipsSearch(searchParam: String): StarshipsSearch

    suspend fun loadStarshipData()
}