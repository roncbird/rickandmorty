package com.example.rickandmorty.base

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.withState

/**
 * For use with [EpoxyBaseFragment.epoxyController].
 *
 * This builds Epoxy models in a background thread.
 *
 * Copied from the MvRx Sample app: https://github.com/airbnb/MvRx/tree/master/sample
 */
open class MvRxEpoxyController(
    val buildModelsCallback: EpoxyController.() -> Unit = {}
) : AsyncEpoxyController() {

    override fun buildModels() {
        buildModelsCallback()
    }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 */
fun EpoxyBaseFragment.simpleController(
    buildModels: EpoxyController.() -> Unit
) = MvRxEpoxyController {
    // Models are built asynchronously, so it is possible that this is called after the fragment
    // is detached under certain race conditions.
    if (view == null || isRemoving) return@MvRxEpoxyController
    buildModels()
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewmodel will be provided.
 */
fun <S : MvRxState, A : BaseMvRxViewModel<S>> EpoxyBaseFragment.simpleController(
    viewModel: A,
    buildModels: EpoxyController.(state: S) -> Unit
) = MvRxEpoxyController {
    if (view == null || isRemoving || !isAdded) return@MvRxEpoxyController
    withState(viewModel) { state ->
        buildModels(state)
    }
}
