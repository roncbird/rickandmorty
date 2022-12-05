package com.example.rickandmorty.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyDataBindingPattern
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.MvRxView
import com.example.rickandmorty.R

/**
 * Influenced by Base Fragment in the MvRx Sample App
 *
 * https://github.com/airbnb/MvRx/tree/master/sample
 */
@EpoxyDataBindingPattern(rClass = R::class, layoutPrefix = "epoxy")
abstract class EpoxyBaseFragment : Fragment(), MvRxView {

    private lateinit var recyclerView: EpoxyRecyclerView
    protected val epoxyController by lazy { epoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        epoxyController.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_epoxy_base, container, false).apply {
            recyclerView = findViewById(R.id.epoxy_recycler_view)
            recyclerView.setController(epoxyController)
        }
    }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }

    /**
     * Provide the EpoxyController to use when building models for this Fragment.
     * Basic usages can simply use [simpleController]
     */
    abstract fun epoxyController(): MvRxEpoxyController

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }

}