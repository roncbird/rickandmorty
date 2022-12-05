package com.example.rickandmorty.view.characters

import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.fragmentViewModel
import com.example.rickandmorty.base.EpoxyBaseFragment
import com.example.rickandmorty.base.simpleController
import com.example.rickandmorty.characterRow
import com.example.rickandmorty.model.Result

class CharactersFragment : EpoxyBaseFragment() {

    private val viewModel: CharactersViewModel by fragmentViewModel()

    override fun epoxyController() = simpleController(viewModel) { state ->
        if (state.charactersResponse.complete) {
            createCharacterRows(state.charactersResponse()?.results.orEmpty())
        }
    }

    private fun EpoxyController.createCharacterRows(results: List<Result>) {
        results.sortedBy {
            it.name
        }.forEach {
            characterRow {
                id(it.id)
                imageUrl(it.image)
                characterName(it.name)
                characterStatus(it.status)
            }
        }
    }

}