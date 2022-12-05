package com.example.rickandmorty.koin

import com.example.rickandmorty.repository.CharactersRepo
import com.example.rickandmorty.repository.LocationsRepo
import org.koin.dsl.module

val RepositoryModule = module {

    single{
        CharactersRepo(get())
    }

    single{
        LocationsRepo(get())
    }

}