package dev.passerby.montekristtestproject.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.google.android.material.tabs.TabLayoutMediator
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.FragmentMainBinding
import dev.passerby.montekristtestproject.presentation.adapters.MainViewPagerAdapter
import dev.passerby.montekristtestproject.presentation.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding is null")

    private val viewModel: MainViewModel by navGraphViewModels(R.id.navigation_main)

    private val pagerArray = arrayOf(
        "People",
        "Planets",
        "Starships"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val adapter = MainViewPagerAdapter(parentFragmentManager, lifecycle)
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = pagerArray[position]
            }.attach()
            mainSearchTextInputEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val searchText = s?.trim().toString()
                    if (searchText.length > 1) {
                        with(viewModel) {
                            getPeopleSearch(searchText)
                            getPlanetsSearch(searchText)
                        }
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}