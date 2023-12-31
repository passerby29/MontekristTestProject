package dev.passerby.montekristtestproject.data.network

import dev.passerby.montekristtestproject.data.models.dto.PeopleSearchDto
import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetsSearchDto
import dev.passerby.montekristtestproject.data.models.dto.StarshipInfoDto
import dev.passerby.montekristtestproject.data.models.dto.StarshipsSearchDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    suspend fun getPeopleSearch(@Query(QUERY_PARAM_SEARCH) searchParam: String): PeopleSearchDto

    @GET("people/{id}/")
    suspend fun getPersonInfo(@Path("id") id: Int): PersonInfoDto

    @GET("planets/")
    suspend fun getPlanetSearch(@Query(QUERY_PARAM_SEARCH) searchParam: String): PlanetsSearchDto

    @GET("planets/{id}/")
    suspend fun getPlanetInfo(@Path("id") id: Int): PlanetInfoDto

    @GET("starships/")
    suspend fun getStarshipsSearch(@Query(QUERY_PARAM_SEARCH) searchParam: String): StarshipsSearchDto

    @GET("starships/{id}/")
    suspend fun getStarshipInfo(@Path("id") id: Int): StarshipInfoDto

    companion object {
        private const val QUERY_PARAM_SEARCH = "search"
    }
}