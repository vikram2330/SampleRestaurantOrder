package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.Restraurant

interface SearchRestaurantUseCase {
    suspend operator fun invoke(searchText: String): List<Restraurant>
}