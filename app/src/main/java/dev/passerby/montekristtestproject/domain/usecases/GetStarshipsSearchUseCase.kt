package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.StarshipRepository

class GetStarshipsSearchUseCase(
    private val repository: StarshipRepository
) {

    suspend operator fun invoke(searchParam: String) = repository.getStarshipsSearch(searchParam)
}