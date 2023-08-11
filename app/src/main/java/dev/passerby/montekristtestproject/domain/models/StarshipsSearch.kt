package dev.passerby.montekristtestproject.domain.models

data class StarshipsSearch(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<StarshipInfo>
)