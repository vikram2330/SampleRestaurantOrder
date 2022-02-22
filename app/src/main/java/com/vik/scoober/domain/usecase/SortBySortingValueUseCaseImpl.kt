package com.vik.scoober.domain.usecase

import com.vik.scoober.di.DefaultDispatcher
import com.vik.scoober.domain.model.AverageProductPrice
import com.vik.scoober.domain.model.BestMatch
import com.vik.scoober.domain.model.DeliveryCost
import com.vik.scoober.domain.model.Distance
import com.vik.scoober.domain.model.MinimumCost
import com.vik.scoober.domain.model.Newest
import com.vik.scoober.domain.model.Popularity
import com.vik.scoober.domain.model.RatingAverage
import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.domain.model.SortType
import com.vik.scoober.domain.model.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SortBySortingValueUseCaseImpl @Inject constructor(@DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher) :
    SortBySortingValueUseCase {

    override suspend fun invoke(list: List<Restraurant>, sortType: SortType): List<Restraurant> {
        return withContext(defaultDispatcher) {
            when (sortType) {
                AverageProductPrice -> list.sortedBy { it.sortingValues.averageProductPrice }
                BestMatch -> list.sortedBy { it.sortingValues.bestMatch }
                DeliveryCost -> list.sortedBy { it.sortingValues.deliveryCosts }
                Distance -> list.sortedBy { it.sortingValues.distance }
                Popularity -> list.sortedBy { it.sortingValues.popularity }
                MinimumCost -> list.sortedBy { it.sortingValues.minCost }
                Newest -> list.sortedBy { it.sortingValues.newest }
                RatingAverage -> list.sortedBy { it.sortingValues.ratingAverage }
                Status -> list.sortedBy { it.status.value }
            }
        }
    }
}
