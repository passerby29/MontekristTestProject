package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class GetPeopleSearchUseCase(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(searchParam: String) = repository.getPeopleSearch(searchParam)
}