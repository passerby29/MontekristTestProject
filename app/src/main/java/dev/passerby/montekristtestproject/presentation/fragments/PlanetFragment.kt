package dev.passerby.montekristtestproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.FragmentPlanetBinding
import dev.passerby.montekristtestproject.presentation.adapters.planet.PlanetInfoAdapter
import dev.passerby.montekristtestproject.presentation.viewmodels.MainViewModel

class PlanetFragment : Fragment() {

    private var _binding: FragmentPlanetBinding? = null
    private val binding: FragmentPlanetBinding
        get() = _binding ?: throw RuntimeException("FragmentPlanetBinding is null")

    private val viewModel: MainViewModel by navGraphViewModels(R.id.navigation_main)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planetInfoAdapter = PlanetInfoAdapter(requireContext())
        binding.planetRecyclerView.apply {
            adapter = planetInfoAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
        viewModel.planetsSearch.observe(viewLifecycleOwner) {
            planetInfoAdapter.submitList(it?.results)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}