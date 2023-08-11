package dev.passerby.montekristtestproject.data.models.dto

data class PlanetsSearchDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PlanetInfoDto>
)