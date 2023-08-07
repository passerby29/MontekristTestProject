package dev.passerby.montekristtestproject.data.mapper

import dev.passerby.montekristtestproject.data.models.db.StarshipDbModel
import dev.passerby.montekristtestproject.data.models.dto.StarshipInfoDto
import dev.passerby.montekristtestproject.domain.models.StarshipInfo

class StarshipMapper {

    fun mapDtoToDbModel(dto: StarshipInfoDto) = StarshipDbModel(
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

    fun mapDbModelToEntity(dbModel: StarshipDbModel) = StarshipInfo(
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
}