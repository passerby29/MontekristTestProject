package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.StarshipRepository

class LoadStarshipDataUseCase(
    private val repository: StarshipRepository
) {

    suspend operator fun invoke() = repository.loadStarshipData()
}