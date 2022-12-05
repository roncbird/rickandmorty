package com.example.rickandmorty.model

data class Characters(
    val info: Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?,
)

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)

