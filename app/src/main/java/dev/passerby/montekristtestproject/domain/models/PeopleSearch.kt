package dev.passerby.montekristtestproject.domain.models

data class PeopleSearch(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PersonInfo>
)