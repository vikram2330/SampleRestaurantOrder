package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.Restraurant

interface GetRestaurantListUseCase {

    suspend operator fun invoke(): List<Restraurant>
}