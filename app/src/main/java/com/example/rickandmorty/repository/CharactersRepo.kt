package com.example.rickandmorty.repository

import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.network.Api
import io.reactivex.Single

class CharactersRepo(private val api: Api) {

    fun getCharacters(pageNumber: String): Single<Characters> = api.getCharacters(pageNumber)

}