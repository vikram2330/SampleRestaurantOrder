package com.vik.scoober.data.mapper

import com.vik.scoober.data.model.RestraurantDTO
import com.vik.scoober.domain.model.Close
import com.vik.scoober.domain.model.Open
import com.vik.scoober.domain.model.OpeningStatus
import com.vik.scoober.domain.model.OrderAhead
import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.mapper.Mapper
import javax.inject.Inject

class RestaurantMapper @Inject constructor(private val sortingValuesMapper: SortingValuesMapper) :
    Mapper<RestraurantDTO, Restraurant> {
    override fun map(input: RestraurantDTO): Restraurant {
        return Restraurant(
            input.id,
            input.name,
            getStatus(input.status),
            sortingValuesMapper.map(input.sortingValues)
        )
    }

    private fun getStatus(status: String): OpeningStatus {
        return when (status) {
            "open" -> Open
            "order ahead" -> OrderAhead
            else -> Close

        }
    }

}