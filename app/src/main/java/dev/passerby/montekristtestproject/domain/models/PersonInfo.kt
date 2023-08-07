package dev.passerby.montekristtestproject.domain.models

data class PersonInfo(
    val birthYear: String,
    val created: String,
    val edited: String,
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorld: String,
    val mass: String,
    val name: String,
    val skinColor: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>
)