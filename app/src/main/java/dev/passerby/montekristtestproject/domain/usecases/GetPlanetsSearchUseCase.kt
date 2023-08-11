package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PlanetRepository

class GetPlanetsSearchUseCase(
    private val repository: PlanetRepository
) {

    suspend operator fun invoke(searchParam: String) = repository.getPlanetSearch(searchParam)
}