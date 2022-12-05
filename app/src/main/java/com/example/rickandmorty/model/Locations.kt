package com.example.rickandmorty.model

data class Locations(
    val info: LocationInfo,
    val results: List<LocationResult>
)

data class LocationInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?,
)

data class LocationResult(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)