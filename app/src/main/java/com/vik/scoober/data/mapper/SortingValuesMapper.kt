package com.vik.scoober.data.mapper

import com.vik.scoober.data.model.SortingValuesDTO
import com.vik.scoober.domain.model.SortingValues
import com.vik.scoober.mapper.Mapper
import javax.inject.Inject

class SortingValuesMapper @Inject constructor() : Mapper<SortingValuesDTO, SortingValues> {
    override fun map(input: SortingValuesDTO): SortingValues {
        return SortingValues(
            input.bestMatch,
            input.newest,
            input.ratingAverage,
            input.distance,
            input.popularity,
            input.averageProductPrice,
            input.deliveryCosts,
            input.minCost
        )
    }
}