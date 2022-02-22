package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.AverageProductPrice
import com.vik.scoober.domain.model.BestMatch
import com.vik.scoober.domain.model.DeliveryCost
import com.vik.scoober.domain.model.Distance
import com.vik.scoober.domain.model.MinimumCost
import com.vik.scoober.domain.model.Newest
import com.vik.scoober.domain.model.Popularity
import com.vik.scoober.domain.model.RatingAverage
import com.vik.scoober.domain.model.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SortBySortingValueUseCaseImplTest {

    private val sut = SortBySortingValueUseCaseImpl(Dispatchers.Default)

    @Test
    fun `invoke should return list sorted by BestMatch `() {
        runBlocking {
            val list = ListProvider.getListForBestMatchSorting()
            //test list is unsorted
            assert(list.first().sortingValues.bestMatch > list.last().sortingValues.bestMatch)
            val result = sut.invoke(list, BestMatch)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.bestMatch <= result[i + 1].sortingValues.bestMatch)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by Newest `() {
        runBlocking {
            val list = ListProvider.getListForNewestSorting()
            //test list is unsorted
            assert(list.first().sortingValues.newest > list.last().sortingValues.newest)
            val result = sut.invoke(list, Newest)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.newest <= result[i + 1].sortingValues.newest)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by RatingAverage `() {
        runBlocking {
            val list = ListProvider.getListForRatingAverageSorting()
            //test list is unsorted
            assert(list.first().sortingValues.ratingAverage > list.last().sortingValues.ratingAverage)
            val result = sut.invoke(list, RatingAverage)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.ratingAverage <= result[i + 1].sortingValues.ratingAverage)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by Distance`() {
        runBlocking {
            val list = ListProvider.getListForDistanceSorting()
            //test list is unsorted
            assert(list.first().sortingValues.distance > list.last().sortingValues.distance)
            val result = sut.invoke(list, Distance)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.distance <= result[i + 1].sortingValues.distance)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by Popularity `() {
        runBlocking {
            val list = ListProvider.getListForPopularitySorting()
            //test list is unsorted
            assert(list.first().sortingValues.popularity > list.last().sortingValues.popularity)
            val result = sut.invoke(list, Popularity)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.popularity <= result[i + 1].sortingValues.popularity)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by AverageProductPrice `() {
        runBlocking {
            val list = ListProvider.getListForAverageProductPriceSorting()
            //test list is unsorted
            assert(list.first().sortingValues.averageProductPrice > list.last().sortingValues.averageProductPrice)
            val result = sut.invoke(list, AverageProductPrice)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.averageProductPrice <= result[i + 1].sortingValues.averageProductPrice)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by DeliveryCosts `() {
        runBlocking {
            val list = ListProvider.getListForDeliveryCostsSorting()
            //test list is unsorted
            assert(list.first().sortingValues.deliveryCosts > list.last().sortingValues.deliveryCosts)
            val result = sut.invoke(list, DeliveryCost)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.deliveryCosts <= result[i + 1].sortingValues.deliveryCosts)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by minCost `() {
        runBlocking {
            val list = ListProvider.getListForMinCostSorting()
            //test list is unsorted
            assert(list.first().sortingValues.minCost > list.last().sortingValues.minCost)
            val result = sut.invoke(list, MinimumCost)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].sortingValues.minCost <= result[i + 1].sortingValues.minCost)
            }
        }
    }

    @Test
    fun `invoke should return list sorted by Status `() {
        runBlocking {
            val list = ListProvider.getListForStatusSorting()
            //test list is unsorted
            assert(list.first().status.value > list.last().status.value)
            val result = sut.invoke(list, Status)
            //test list is sorted
            for (i in 0 until result.size - 1) {
                assert(result[i].status.value <= result[i + 1].status.value)
            }
        }
    }
}