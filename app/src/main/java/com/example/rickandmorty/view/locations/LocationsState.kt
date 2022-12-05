package com.example.rickandmorty.view.locations

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.rickandmorty.model.Locations

data class LocationsState(
    val locationsResponse: Async<Locations> = Uninitialized,
) : MvRxState