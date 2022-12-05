package com.example.rickandmorty.view.characters

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.rickandmorty.repository.CharactersRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.get

class CharactersViewModel(
    initialState: CharactersState,
    private val charactersRepo: CharactersRepo,
) : BaseMvRxViewModel<CharactersState>(initialState) {

    init {
        getCharacters()
    }

    private fun getCharacters() {
        charactersRepo.getCharacters(FIRST_CHARACTER_PAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .execute {
                copy(
                    charactersResponse = it
                )
            }
    }

    companion object : MavericksViewModelFactory<CharactersViewModel, CharactersState> {

        private const val FIRST_CHARACTER_PAGE = "1"

        override fun create(
            viewModelContext: ViewModelContext,
            state: CharactersState,
        ): CharactersViewModel {
            return CharactersViewModel(
                state,
                viewModelContext.activity.get(),
            )
        }

    }

}