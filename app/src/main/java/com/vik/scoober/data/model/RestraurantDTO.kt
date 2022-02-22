package com.vik.scoober.data.model

data class RestraurantDTO(
    val id: String,
    val name: String,
    val status: String,
    val sortingValues: SortingValuesDTO
)
