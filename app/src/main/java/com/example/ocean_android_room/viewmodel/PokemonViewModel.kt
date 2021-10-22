package com.example.ocean_android_room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ocean_android_room.model.AppDatabase
import com.example.ocean_android_room.model.PokemonDao
import com.example.ocean_android_room.model.PokemonEntity

class PokemonViewModel(application: Application): AndroidViewModel(application) {
    val pokemons: LiveData<List<PokemonEntity>>

    private val db: AppDatabase
    private val pokemonDao: PokemonDao

    init {
        db = AppDatabase.getDatabase(application)
        pokemonDao = db.pokemonDao()

        pokemons = pokemonDao.findAll()
    }

    fun createPokemon() {
        Thread {
            val pokemon = PokemonEntity(null,"Pikachu", "https://imagem.com/pikachu.png")
            pokemonDao.create(pokemon)
        }.start()
    }

    fun limpaPokemon() {
        Thread {
            pokemonDao.limpa()
        }.start()
    }
}