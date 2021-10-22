package com.example.ocean_android_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.ocean_android_room.viewmodel.PokemonViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonViewModel: PokemonViewModel =
            ViewModelProvider(this)
                .get(PokemonViewModel::class.java)

        val tvPokemons = findViewById<TextView>(R.id.tvPokemons)
        val btInserir = findViewById<Button>(R.id.btInserir)
        val btLimpar = findViewById<Button>(R.id.btLimpar)

        btInserir.setOnClickListener {
            pokemonViewModel.createPokemon()
        }

        btLimpar.setOnClickListener {
            pokemonViewModel.limpaPokemon()
        }

        pokemonViewModel.pokemons.observe(this, {
            tvPokemons.text = ""
            it.forEach { pokemon ->
                tvPokemons.append("${pokemon.name}\n")
            }
        })
    }
}