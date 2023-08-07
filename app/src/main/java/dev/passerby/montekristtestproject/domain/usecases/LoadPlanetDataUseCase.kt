package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PlanetRepository

class LoadPlanetDataUseCase(
    private val repository: PlanetRepository
) {

    suspend operator fun invoke() = repository.loadPlanetData()
}