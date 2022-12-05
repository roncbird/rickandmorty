package com.example.rickandmorty.repository

import com.example.rickandmorty.model.Locations
import com.example.rickandmorty.network.Api
import io.reactivex.Single

class LocationsRepo(private val api: Api) {

    fun getLocations(): Single<Locations> = api.getLocations()

}