package dev.passerby.montekristtestproject.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.passerby.montekristtestproject.data.repository.PersonRepositoryImpl
import dev.passerby.montekristtestproject.domain.models.PersonInfo
import dev.passerby.montekristtestproject.domain.usecases.GetPersonInfoListUseCase
import dev.passerby.montekristtestproject.domain.usecases.GetPersonInfoUseCase
import dev.passerby.montekristtestproject.domain.usecases.LoadPersonDataUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PersonRepositoryImpl(application)

    private val getPersonInfoListUseCase = GetPersonInfoListUseCase(repository)
    private val getPersonInfoUseCase = GetPersonInfoUseCase(repository)
    private val loadPersonDataUseCase = LoadPersonDataUseCase(repository)

    val personListInfo = getPersonInfoListUseCase()

    fun getPersonInfo(name: String) = getPersonInfoUseCase(name)

    init {
        viewModelScope.launch {
            loadPersonDataUseCase()
        }
    }
}