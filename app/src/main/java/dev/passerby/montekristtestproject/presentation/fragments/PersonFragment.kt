package dev.passerby.montekristtestproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.passerby.montekristtestproject.databinding.FragmentPersonBinding
import dev.passerby.montekristtestproject.presentation.adapters.person.PersonInfoAdapter
import dev.passerby.montekristtestproject.presentation.viewmodels.MainViewModel

class PersonFragment : Fragment() {

    private var _binding: FragmentPersonBinding? = null
    private val binding: FragmentPersonBinding
        get() = _binding ?: throw RuntimeException("FragmentPersonBinding is null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personInfoAdapter = PersonInfoAdapter(requireContext())
        binding.personRecyclerView.apply {
            adapter = personInfoAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
        viewModel.personListInfo.observe(viewLifecycleOwner) {
            personInfoAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}