package com.example.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty.R.string
import com.example.rickandmorty.databinding.FragmentHomeBinding
import com.example.rickandmorty.view.adapter.MainActivityPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RickMortyHomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.viewPager.adapter = MainActivityPagerAdapter(this)
        binding.viewPager.offscreenPageLimit = 1
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = if (position == CHARACTERS) {
                getString(string.character_tab)
            } else {
                getString(string.location_tab)
            }
        }.attach()
    }

    companion object {

        const val CHARACTERS = 0

    }
}