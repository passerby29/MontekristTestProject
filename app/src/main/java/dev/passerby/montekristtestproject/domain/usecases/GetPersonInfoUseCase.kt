package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class GetPersonInfoUseCase(
    private val repository: PersonRepository
) {

    operator fun invoke() = repository.getPersonInfo()
}