package dev.passerby.montekristtestproject.data.models.dto

data class PeopleSearchDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PersonInfoDto>
)