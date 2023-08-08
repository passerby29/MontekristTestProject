package dev.passerby.montekristtestproject.presentation.adapters.planet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.ItemPlanetInfoBinding
import dev.passerby.montekristtestproject.domain.models.PlanetInfo

class PlanetInfoAdapter(
    private val context: Context
) : ListAdapter<PlanetInfo, PlanetInfoViewHolder>(PlanetInfoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetInfoViewHolder {
        val binding = ItemPlanetInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlanetInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetInfoViewHolder, position: Int) {
        val planet = getItem(position)
        with(holder.binding) {
            with(planet) {
                planetNameTextView.text = name
                planetDiameterTextView.text = String.format(
                    context.resources.getString(R.string.planet_diameter_template),
                    diameter
                )
                planetPopulationTextView.text = String.format(
                    context.resources.getString(R.string.planet_population_template),
                    population
                )
            }
        }
    }
}