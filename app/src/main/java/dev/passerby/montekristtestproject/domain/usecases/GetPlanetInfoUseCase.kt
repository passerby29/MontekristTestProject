package dev.passerby.montekristtestproject.domain.usecases

import dev.passerby.montekristtestproject.domain.repository.PlanetRepository

class GetPlanetInfoUseCase(
    private val repository: PlanetRepository
) {

    operator fun invoke(name: String) = repository.getPlanetInfo(name)
}