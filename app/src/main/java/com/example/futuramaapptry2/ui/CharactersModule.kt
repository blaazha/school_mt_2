package com.example.futuramaapptry2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.futuramaapptry2.R
import com.example.futuramaapptry2.api.Character

class CharactersAdapter(private var characters: List<Character> ,
                        private val clickListener: CharacterClickListener) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.textView.text = "${character.name.first} ${character.name.middle} ${character.name.last}"

        holder.itemView.setOnClickListener {
            clickListener.onCharacterClicked(character)
        }
    }

    override fun getItemCount() = characters.size

    fun updateCharacters(newCharacters: List<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }
}

interface CharacterClickListener {
    fun onCharacterClicked(character: Character)
}