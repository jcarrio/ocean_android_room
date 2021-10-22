package com.example.ocean_android_room.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemons")
    fun findAll(): LiveData<List<PokemonEntity>>

    @Insert
    fun create(pokemon: PokemonEntity)

    @Query("DELETE FROM pokemons")
    fun limpa()
}