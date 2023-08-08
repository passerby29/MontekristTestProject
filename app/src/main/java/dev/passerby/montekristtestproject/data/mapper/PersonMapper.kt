package dev.passerby.montekristtestproject.data.mapper

import dev.passerby.montekristtestproject.data.models.db.PersonInfoDbModel
import dev.passerby.montekristtestproject.data.models.dto.PeopleSearchDto
import dev.passerby.montekristtestproject.data.models.dto.PersonInfoDto
import dev.passerby.montekristtestproject.domain.models.PeopleSearch
import dev.passerby.montekristtestproject.domain.models.PersonInfo

class PersonMapper {

    fun mapDtoToDbModel(dto: PersonInfoDto) = PersonInfoDbModel(
        birthYear = dto.birth_year,
        created = dto.created,
        edited = dto.edited,
        eyeColor = dto.eye_color,
        films = dto.films,
        gender = dto.gender,
        hairColor = dto.hair_color,
        height = dto.height,
        homeWorld = dto.homeworld,
        mass = dto.mass,
        name = dto.name,
        skinColor = dto.skin_color,
        species = dto.species,
        starships = dto.starships,
        url = dto.url,
        vehicles = dto.vehicles
    )

    fun mapDbModelToEntity(dbModel: PersonInfoDbModel) = PersonInfo(
        birthYear = dbModel.birthYear,
        created = dbModel.created,
        edited = dbModel.edited,
        eyeColor = dbModel.eyeColor,
        films = dbModel.films,
        gender = dbModel.gender,
        hairColor = dbModel.hairColor,
        height = dbModel.height,
        homeWorld = dbModel.homeWorld,
        mass = dbModel.mass,
        name = dbModel.name,
        skinColor = dbModel.skinColor,
        species = dbModel.species,
        starships = dbModel.starships,
        url = dbModel.url,
        vehicles = dbModel.vehicles
    )

    fun mapDtoToEntity(dto: PeopleSearchDto) = PeopleSearch(
        count = dto.count,
        next = dto.next,
        previous = dto.previous,
        results = mapDtoListToEntity(dto.results)
    )

    private fun mapDtoListToEntity(dto: List<PersonInfoDto>): List<PersonInfo> {
        val info = mutableListOf<PersonInfo>()
        for (dtoItem in dto) {
            info.add(
                PersonInfo(
                    dtoItem.birth_year,
                    dtoItem.created,
                    dtoItem.edited,
                    dtoItem.eye_color,
                    dtoItem.films,
                    dtoItem.gender,
                    dtoItem.hair_color,
                    dtoItem.height,
                    dtoItem.homeworld,
                    dtoItem.mass,
                    dtoItem.name,
                    dtoItem.skin_color,
                    dtoItem.species,
                    dtoItem.starships,
                    dtoItem.url,
                    dtoItem.vehicles,
                )
            )
        }
        return info
    }
}