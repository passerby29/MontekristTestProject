package dev.passerby.montekristtestproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.FragmentStarshipBinding
import dev.passerby.montekristtestproject.presentation.adapters.starship.StarshipInfoAdapter
import dev.passerby.montekristtestproject.presentation.viewmodels.MainViewModel

class StarshipFragment : Fragment() {

    private var _binding: FragmentStarshipBinding? = null
    private val binding: FragmentStarshipBinding
        get() = _binding ?: throw RuntimeException("FragmentStarshipBinding is null")

    private val viewModel: MainViewModel by navGraphViewModels(R.id.navigation_main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarshipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val starshipInfoAdapter = StarshipInfoAdapter(requireContext())
        binding.starshipRecyclerView.apply {
            adapter = starshipInfoAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
        viewModel.starshipsSearch.observe(viewLifecycleOwner) {
            starshipInfoAdapter.submitList(it?.results)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}