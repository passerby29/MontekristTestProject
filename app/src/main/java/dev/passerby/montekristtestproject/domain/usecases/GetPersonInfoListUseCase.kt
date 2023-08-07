package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class GetPersonInfoListUseCase(
    private val repository: PersonRepository
) {

    operator fun invoke() = repository.getPersonInfoList()
}