package dev.passerby.montekristtestproject.data.mapper

import dev.passerby.montekristtestproject.data.models.db.PersonInfoDbModel
import dev.passerby.montekristtestproject.data.models.db.PlanetInfoDbModel
import dev.passerby.montekristtestproject.data.models.dto.PlanetInfoDto
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.models.PlanetInfo

class PlanetMapper {

    fun mapDtoToDbModel(dto: PlanetInfoDto) = PlanetInfoDbModel(
        climate = dto.climate,
        created = dto.created,
        diameter = dto.diameter,
        edited = dto.edited,
        films = dto.films,
        gravity = dto.gravity,
        name = dto.name,
        orbitalPeriod = dto.orbital_period,
        population = dto.population,
        residents = dto.residents,
        rotationPeriod = dto.rotation_period,
        surfaceWater = dto.surface_water,
        terrain = dto.terrain,
        url = dto.url
    )

    fun mapDbModelToEntity(dbModel: PlanetInfoDbModel) = PlanetInfo(
        climate = dbModel.climate,
        created = dbModel.created,
        diameter = dbModel.diameter,
        edited = dbModel.edited,
        films = dbModel.films,
        gravity = dbModel.gravity,
        name = dbModel.name,
        orbitalPeriod = dbModel.orbitalPeriod,
        population = dbModel.population,
        residents = dbModel.residents,
        rotationPeriod = dbModel.rotationPeriod,
        surfaceWater = dbModel.surfaceWater,
        terrain = dbModel.terrain,
        url = dbModel.url,
    )
}