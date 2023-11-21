package com.example.futuramaapptry2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide
import com.example.futuramaapptry2.api.Character
class DetailsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val character = intent.getSerializableExtra("characterKey") as Character
        fillTemplate(character)

        val backButton: Button = findViewById(R.id.detailsBackButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fillTemplate(character: Character){
        val characterAgeView: TextView = findViewById(R.id.characterAge)
        characterAgeView.text = "Věk: ${character.age}"
        val characterNameTextView: TextView = findViewById(R.id.characterName)
        characterNameTextView.text = "${character.name.first} ${character.name.middle} ${character.name.last}"

        val imageView: ImageView = findViewById(R.id.imageView)

        Glide.with(this)
            .load(character.images.main)
            .into(imageView)
    }
}