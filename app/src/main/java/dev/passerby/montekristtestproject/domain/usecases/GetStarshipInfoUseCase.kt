package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.StarshipRepository

class GetStarshipInfoUseCase(
    private val repository: StarshipRepository
) {

    operator fun invoke() = repository.getStarshipInfo()
}