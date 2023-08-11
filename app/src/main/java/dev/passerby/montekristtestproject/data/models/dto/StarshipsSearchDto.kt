package dev.passerby.montekristtestproject.data.models.dto

data class StarshipsSearchDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<StarshipInfoDto>
)