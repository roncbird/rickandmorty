package com.example.rickandmorty.view.characters

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.Result

data class CharactersState(
    val charactersResponse: Async<Characters> = Uninitialized,
) : MvRxState