package dev.passerby.montekristtestproject.data.mapper

import dev.passerby.montekristtestproject.data.models.db.PersonInfoDbModel
import dev.passerby.montekristtestproject.data.models.db.PlanetInfoDbModel
import dev.passerby.montekristtestproject.data.models.dto.PeopleSearchDto
import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetInfoDto
import dev.passerby.montekristtestproject.data.models.dto.PlanetsSearchDto
import dev.passerby.montekristtestproject.domain.models.PeopleSearch
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.models.PlanetInfo
import dev.passerby.montekristtestproject.domain.models.PlanetsSearch

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

    fun mapDtoToEntity(dto: PlanetsSearchDto) = PlanetsSearch(
        count = dto.count,
        next = dto.next,
        previous = dto.previous,
        results = mapDtoListToEntity(dto.results)
    )

    private fun mapDtoListToEntity(dto: List<PlanetInfoDto>): List<PlanetInfo> {
        val info = mutableListOf<PlanetInfo>()
        for (dtoItem in dto) {
            info.add(
                PlanetInfo(
                    dtoItem.climate,
                    dtoItem.created,
                    dtoItem.diameter,
                    dtoItem.edited,
                    dtoItem.films,
                    dtoItem.gravity,
                    dtoItem.name,
                    dtoItem.orbital_period,
                    dtoItem.population,
                    dtoItem.residents,
                    dtoItem.rotation_period,
                    dtoItem.surface_water,
                    dtoItem.terrain,
                    dtoItem.url,)
            )
        }
        return info
    }
}