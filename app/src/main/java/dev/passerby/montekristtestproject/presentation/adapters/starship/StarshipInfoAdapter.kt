package dev.passerby.montekristtestproject.presentation.adapters.starship

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.ItemStarshipInfoBinding
import dev.passerby.montekristtestproject.domain.models.StarshipInfo

class StarshipInfoAdapter(
    private val context: Context
) : ListAdapter<StarshipInfo, StarshipInfoViewHolder>(StarshipInfoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipInfoViewHolder {
        val binding = ItemStarshipInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StarshipInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StarshipInfoViewHolder, position: Int) {
        val starship = getItem(position)
        with(holder.binding) {
            with(starship) {
                starshipNameTextView.text = name
                starshipModelTextView.text = String.format(
                    context.resources.getString(R.string.starship_model_template),
                    model
                )
                starshipManufacturerTextView.text = String.format(
                    context.resources.getString(R.string.starship_manufacturer_template),
                    manufacturer
                )
                starshipPassengersTextView.text = String.format(
                    context.resources.getString(R.string.starship_passengers_template),
                    passengers
                )
            }
        }
    }
}