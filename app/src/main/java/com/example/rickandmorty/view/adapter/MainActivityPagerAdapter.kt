package com.example.rickandmorty.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandmorty.view.characters.CharactersFragment
import com.example.rickandmorty.view.locations.LocationsFragment

class MainActivityPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = TOTAL_PAGES

    override fun createFragment(position: Int): Fragment {
        return if (position == CHARACTERS) {
            CharactersFragment()
        } else {
            LocationsFragment()
        }
    }

    companion object {
        const val TOTAL_PAGES = 2
        const val CHARACTERS = 0
    }

}