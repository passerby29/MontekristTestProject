package dev.passerby.montekristtestproject.data.network

import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetInfoDto
import dev.passerby.montekristtestproject.data.models.dto.StarshipInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("people/{id}/")
    suspend fun getPersonInfo(@Path("id") id: Int): PersonInfoDto

    @GET("planets/{id}/")
    suspend fun getPlanetInfo(@Path("id") id: Int): PlanetInfoDto

    @GET("starships/{id}/")
    suspend fun getStarshipInfo(@Path("id") id: Int): StarshipInfoDto
}