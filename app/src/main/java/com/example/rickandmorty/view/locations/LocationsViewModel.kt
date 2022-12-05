package com.example.rickandmorty.view.locations

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.rickandmorty.repository.CharactersRepo
import com.example.rickandmorty.repository.LocationsRepo
import com.example.rickandmorty.view.characters.CharactersState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.get

class LocationsViewModel(
    initialState: LocationsState,
    private val locationsRepo: LocationsRepo,
) : BaseMvRxViewModel<LocationsState>(initialState) {

    init {
        getLocations()
    }

    private fun getLocations() {
        locationsRepo.getLocations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .execute {
                copy(locationsResponse = it)
            }
    }

    companion object : MavericksViewModelFactory<LocationsViewModel, LocationsState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: LocationsState,
        ): LocationsViewModel {
            return LocationsViewModel(
                state,
                viewModelContext.activity.get(),
            )
        }

    }

}