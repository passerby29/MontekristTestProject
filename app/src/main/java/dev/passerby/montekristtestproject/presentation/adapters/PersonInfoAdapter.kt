package dev.passerby.montekristtestproject.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.databinding.ItemPersonInfoBinding
import dev.passerby.montekristtestproject.domain.models.PersonInfo

class PersonInfoAdapter(
    private val context: Context
) : ListAdapter<PersonInfo, PersonInfoViewHolder>(PersonInfoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonInfoViewHolder {
        val binding = ItemPersonInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonInfoViewHolder, position: Int) {
        val person = getItem(position)
        with(holder.binding) {
            with(person) {
                val starshipsTemplate = context.resources.getString(R.string.starships_template)
                personNameTextView.text = name
                personStarshipsTextView.text = String.format(starshipsTemplate, starships.size)
                personGenderTextView.text = gender
            }
        }
    }
}