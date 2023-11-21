package com.example.futuramaapptry2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.futuramaapptry2.ui.CharacterClickListener
import com.example.futuramaapptry2.ui.CharactersAdapter

class MainActivity : ComponentActivity(), CharacterClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var charactersAdapter: CharactersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupRecyclerView()
        viewModel.characters.observe(this, Observer { characters ->
            charactersAdapter.updateCharacters(characters)
        })
    }

    private fun setupRecyclerView() {
        val characterList = findViewById<RecyclerView>(R.id.characterList)

        charactersAdapter = CharactersAdapter(emptyList(), this)

        characterList.adapter = charactersAdapter
        characterList.layoutManager = LinearLayoutManager(this)
    }


    override fun onCharacterClicked(character: com.example.futuramaapptry2.api.Character) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("characterKey", character)
        }
        startActivity(intent)
    }
}