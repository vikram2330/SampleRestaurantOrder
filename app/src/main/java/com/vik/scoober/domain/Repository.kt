package com.vik.scoober.domain

import com.vik.scoober.domain.model.Restraurant

interface Repository {

    suspend fun getRestaurants(): Result<List<Restraurant>>
}