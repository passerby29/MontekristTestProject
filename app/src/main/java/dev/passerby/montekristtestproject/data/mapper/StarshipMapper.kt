package dev.passerby.montekristtestproject.data.mapper

import dev.passerby.montekristtestproject.data.models.db.StarshipInfoDbModel
import dev.passerby.montekristtestproject.data.models.dto.StarshipInfoDto
import dev.passerby.montekristtestproject.data.models.dto.StarshipsSearchDto
import dev.passerby.montekristtestproject.domain.models.StarshipInfo
import dev.passerby.montekristtestproject.domain.models.StarshipsSearch

class StarshipMapper {

    fun mapDtoToDbModel(dto: StarshipInfoDto) = StarshipInfoDbModel(
        MGLT = dto.MGLT,
        cargoCapacity = dto.cargo_capacity,
        consumables = dto.consumables,
        costInCredits = dto.cost_in_credits,
        created = dto.created,
        crew = dto.crew,
        edited = dto.edited,
        films = dto.films,
        hyperdriveRating = dto.hyperdrive_rating,
        length = dto.length,
        manufacturer = dto.manufacturer,
        maxAtmospheringSpeed = dto.max_atmosphering_speed,
        model = dto.model,
        name = dto.name,
        passengers = dto.passengers,
        pilots = dto.pilots,
        starshipClass = dto.starship_class,
        url = dto.url,
    )

    fun mapDbModelToEntity(dbModel: StarshipInfoDbModel) = StarshipInfo(
        MGLT = dbModel.MGLT,
        cargoCapacity = dbModel.cargoCapacity,
        consumables = dbModel.consumables,
        costInCredits = dbModel.costInCredits,
        created = dbModel.created,
        crew = dbModel.crew,
        edited = dbModel.edited,
        films = dbModel.films,
        hyperdriveRating = dbModel.hyperdriveRating,
        length = dbModel.length,
        manufacturer = dbModel.manufacturer,
        maxAtmospheringSpeed = dbModel.maxAtmospheringSpeed,
        model = dbModel.model,
        name = dbModel.name,
        passengers = dbModel.passengers,
        pilots = dbModel.pilots,
        starshipClass = dbModel.starshipClass,
        url = dbModel.url,
    )

    fun mapDtoToEntity(dto: StarshipsSearchDto) = StarshipsSearch(
        count = dto.count,
        next = dto.next,
        previous = dto.previous,
        results = mapDtoListToEntity(dto.results)
    )

    private fun mapDtoListToEntity(dto: List<StarshipInfoDto>): List<StarshipInfo> {
        val info = mutableListOf<StarshipInfo>()
        for (dtoItem in dto) {
            info.add(
                StarshipInfo(
                    dtoItem.MGLT,
                    dtoItem.cargo_capacity,
                    dtoItem.consumables,
                    dtoItem.cost_in_credits,
                    dtoItem.created,
                    dtoItem.crew,
                    dtoItem.edited,
                    dtoItem.films,
                    dtoItem.hyperdrive_rating,
                    dtoItem.length,
                    dtoItem.manufacturer,
                    dtoItem.max_atmosphering_speed,
                    dtoItem.model,
                    dtoItem.name,
                    dtoItem.passengers,
                    dtoItem.pilots,
                    dtoItem.starship_class,
                    dtoItem.url,
                )
            )
        }
        return info
    }
}