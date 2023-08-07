package dev.passerby.montekristtestproject.data.network

import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getPersonInfo(): List<PersonInfoDto>
}