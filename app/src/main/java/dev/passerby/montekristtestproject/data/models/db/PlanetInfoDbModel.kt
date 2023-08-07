package dev.passerby.montekristtestproject.data.models.db

import androidx.room.Entity

@Entity(tableName = "planets")
data class PlanetInfoDbModel(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val films: List<String>,
    val gravity: String,
    val name: String,
    val orbitalPeriod: String,
    val population: String,
    val residents: List<String>,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String,
    val url: String
)
