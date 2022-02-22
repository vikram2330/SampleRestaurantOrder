package com.vik.scoober.domain.model

data class SortingValues(
    val bestMatch: Double = 0.0,
    val newest: Double = 0.0,
    val ratingAverage: Double = 0.0,
    val distance: Double = 0.0,
    val popularity: Double = 0.0,
    val averageProductPrice: Double = 0.0,
    val deliveryCosts: Double = 0.0,
    val minCost: Double = 0.0
)
