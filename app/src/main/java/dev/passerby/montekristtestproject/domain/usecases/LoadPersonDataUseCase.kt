package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PersonRepository

class LoadPersonDataUseCase(
    private val repository: PersonRepository
) {

    suspend operator fun invoke() = repository.loadPersonData()
}