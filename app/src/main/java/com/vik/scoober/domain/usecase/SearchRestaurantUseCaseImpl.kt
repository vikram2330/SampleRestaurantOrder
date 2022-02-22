package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.Restraurant
import javax.inject.Inject

internal class SearchRestaurantUseCaseImpl @Inject constructor(private val getRestaurantListUseCase: GetRestaurantListUseCase): SearchRestaurantUseCase {
    override suspend fun invoke(searchText: String): List<Restraurant> {
       return getRestaurantListUseCase().filter { it.name.contains(searchText, true) }
    }
}