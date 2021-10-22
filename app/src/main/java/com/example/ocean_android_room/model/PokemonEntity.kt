package com.example.ocean_android_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class PokemonEntity(
    // constructor
    @PrimaryKey
    val id: Long?,

    val name: String,

    val imageUrl: String
)