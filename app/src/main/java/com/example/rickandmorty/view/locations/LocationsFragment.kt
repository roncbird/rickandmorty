package com.example.rickandmorty.view.locations

import com.airbnb.mvrx.fragmentViewModel
import com.example.rickandmorty.base.EpoxyBaseFragment
import com.example.rickandmorty.base.simpleController
import com.example.rickandmorty.locationRow

class LocationsFragment : EpoxyBaseFragment() {

    private val viewModel: LocationsViewModel by fragmentViewModel()

    override fun epoxyController() = simpleController(viewModel) { state ->
        if (state.locationsResponse.complete) {
            state.locationsResponse()?.results?.sortedBy {
                it.name
            }?.forEach {
                locationRow {
                    id(it.id)
                    locationName(it.name)
                    locationType(it.type)
                }
            }
        }
    }

}