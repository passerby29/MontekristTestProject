package dev.passerby.montekristtestproject.presentation.adapters.person

import androidx.recyclerview.widget.DiffUtil
import dev.passerby.montekristtestproject.domain.models.PersonInfo

object PersonInfoDiffCallback: DiffUtil.ItemCallback<PersonInfo>() {
    override fun areItemsTheSame(oldItem: PersonInfo, newItem: PersonInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PersonInfo, newItem: PersonInfo): Boolean {
        return oldItem == newItem
    }
}