package dev.passerby.montekristtestproject.data.network

import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetInfoDto
import dev.passerby.montekristtestproject.data.models.dto.StarshipInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getPersonInfo(): List<PersonInfoDto>

    @GET("planets")
    suspend fun getPlanetInfo(): List<PlanetInfoDto>

    @GET("starships")
    suspend fun getStarshipInfo(): List<StarshipInfoDto>
}