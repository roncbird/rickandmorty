package com.example.rickandmorty.network

import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.Locations
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/character")
    fun getCharacters(@Query("page") nextPage: String): Single<Characters>

    @GET("api/location")
    fun getLocations(): Single<Locations>

}