package com.vik.scoober.domain.model

data class Restraurant(
    val id: String,
    val name: String,
    val status: OpeningStatus,
    val sortingValues: SortingValues
)
