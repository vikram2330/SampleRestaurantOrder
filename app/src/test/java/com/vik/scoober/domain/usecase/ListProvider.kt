package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.Close
import com.vik.scoober.domain.model.Open
import com.vik.scoober.domain.model.OrderAhead
import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.domain.model.SortingValues

object ListProvider {

    fun getListForSearch() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues()),
            Restraurant("122", "abc", Open, SortingValues()),
            Restraurant("122", "test", Open, SortingValues()),
            Restraurant("122", "test2", Open, SortingValues()),
        )

    fun getListForBestMatchSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(bestMatch = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(bestMatch = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(bestMatch = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(bestMatch = 7.0)),
        )

    fun getListForNewestSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(newest = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(newest = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(newest = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(newest = 7.0)),
        )

    fun getListForRatingAverageSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(ratingAverage = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(ratingAverage = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(ratingAverage = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(ratingAverage = 7.0)),
        )

    fun getListForDistanceSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(distance = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(distance = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(distance = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(distance = 7.0)),
        )

    fun getListForPopularitySorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(popularity = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(popularity = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(popularity = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(popularity = 7.0)),
        )

    fun getListForAverageProductPriceSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(averageProductPrice = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(averageProductPrice = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(averageProductPrice = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(averageProductPrice = 7.0)),
        )

    fun getListForDeliveryCostsSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(deliveryCosts = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(deliveryCosts = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(deliveryCosts = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(deliveryCosts = 7.0)),
        )

    fun getListForMinCostSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "abc", Open, SortingValues(minCost = 10.0)),
            Restraurant("122", "abc", Open, SortingValues(minCost = 1.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(minCost = 5.0)),
            Restraurant("122", "test2", Close, SortingValues(minCost = 7.0)),
        )

    fun getListForStatusSorting() =
        mutableListOf<Restraurant>(
            Restraurant("122", "test2", Close, SortingValues(minCost = 7.0)),
            Restraurant("122", "abc", Open, SortingValues(minCost = 10.0)),
            Restraurant("122", "test", OrderAhead, SortingValues(minCost = 5.0)),
        )

}
