package dev.passerby.montekristtestproject.presentation.adapters.starship

import androidx.recyclerview.widget.DiffUtil
import dev.passerby.montekristtestproject.domain.models.StarshipInfo

object StarshipInfoDiffCallback : DiffUtil.ItemCallback<StarshipInfo>() {
    override fun areItemsTheSame(oldItem: StarshipInfo, newItem: StarshipInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: StarshipInfo, newItem: StarshipInfo): Boolean {
        return oldItem == newItem
    }
}