package dev.passerby.montekristtestproject.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.passerby.montekristtestproject.presentation.fragments.PersonFragment
import dev.passerby.montekristtestproject.presentation.fragments.PlanetFragment
import dev.passerby.montekristtestproject.presentation.fragments.StarshipFragment

private const val NUM_TABS = 3

class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonFragment()
            1 -> PlanetFragment()
            else -> StarshipFragment()
        }
    }
}