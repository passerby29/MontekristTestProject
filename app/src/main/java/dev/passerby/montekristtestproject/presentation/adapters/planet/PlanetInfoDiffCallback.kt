package dev.passerby.montekristtestproject.presentation.adapters.planet

import androidx.recyclerview.widget.DiffUtil
import dev.passerby.montekristtestproject.domain.models.PlanetInfo

object PlanetInfoDiffCallback : DiffUtil.ItemCallback<PlanetInfo>() {
    override fun areItemsTheSame(oldItem: PlanetInfo, newItem: PlanetInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PlanetInfo, newItem: PlanetInfo): Boolean {
        return oldItem == newItem
    }
}