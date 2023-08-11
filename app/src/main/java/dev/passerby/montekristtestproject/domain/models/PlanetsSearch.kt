package dev.passerby.montekristtestproject.domain.models

data class PlanetsSearch(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PlanetInfo>
)