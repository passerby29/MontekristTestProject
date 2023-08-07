package dev.passerby.montekristtestproject.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.passerby.montekristtestproject.data.repository.PersonRepositoryImpl
import dev.passerby.montekristtestproject.data.repository.PlanetRepositoryImpl
import dev.passerby.montekristtestproject.data.repository.StarshipRepositoryImpl
import dev.passerby.montekristtestproject.domain.usecases.GetPersonInfoListUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetPersonInfoUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetPlanetInfoListUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetPlanetInfoUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetStarshipInfoListUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetStarshipInfoUseCase
import dev.passerby.montekristtestproject.domain.usecases.LoadPersonDataUseCase
import dev.passerby.montekristtestproject.domain.usecases.LoadPlanetDataUseCase
import dev.passerby.montekristtestproject.domain.usecases.LoadStarshipDataUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepositoryImpl(application)
    private val planetRepository = PlanetRepositoryImpl(application)
    private val starshipRepository = StarshipRepositoryImpl(application)

    private val getPersonInfoListUseCase = GetPersonInfoListUseCase(personRepository)
    private val getPersonInfoUseCase = GetPersonInfoUseCase(personRepository)
    private val loadPersonDataUseCase = LoadPersonDataUseCase(personRepository)
    private val getPlanetInfoListUseCase = GetPlanetInfoListUseCase(planetRepository)
    private val getPlanetInfoUseCase = GetPlanetInfoUseCase(planetRepository)
    private val loadPlanetDataUseCase = LoadPlanetDataUseCase(planetRepository)
    private val getStarshipInfoListUseCase = GetStarshipInfoListUseCase(starshipRepository)
    private val getStarshipInfoUseCase = GetStarshipInfoUseCase(starshipRepository)
    private val loadStarshipDataUseCase = LoadStarshipDataUseCase(starshipRepository)

    val personListInfo = getPersonInfoListUseCase()
    val planetListInfo = getPlanetInfoListUseCase()
    val starshipListInfo = getStarshipInfoListUseCase()

    fun getPersonInfo(name: String) = getPersonInfoUseCase(name)
    fun getPlanetInfo(name: String) = getPlanetInfoUseCase(name)
    fun getStarshipInfo(name: String) = getStarshipInfoUseCase(name)

    init {
        viewModelScope.launch {
            loadPersonDataUseCase()
            loadPlanetDataUseCase()
            loadStarshipDataUseCase()
        }
    }
}