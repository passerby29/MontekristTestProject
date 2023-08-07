package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.StarshipRepository

class GetStarshipInfoListUseCase(
    private val repository: StarshipRepository
) {

    operator fun invoke() = repository.getStarshipInfoList()
}