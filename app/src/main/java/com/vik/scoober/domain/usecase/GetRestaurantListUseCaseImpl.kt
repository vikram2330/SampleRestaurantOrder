package com.vik.scoober.domain.usecase

import android.util.Log
import com.vik.scoober.domain.Repository
import com.vik.scoober.domain.model.Restraurant
import javax.inject.Inject

internal class GetRestaurantListUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetRestaurantListUseCase {
    override suspend fun invoke(): List<Restraurant> {
        repository.getRestaurants().fold({ list ->
            return list
        }, {
            Log.d("getRestaurantList", it.message ?: "error while fetching list")
            return emptyList()
        })

    }
}