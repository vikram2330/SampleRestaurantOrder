package com.vik.scoober.domain.model

sealed class SortType(val name: String) {
    companion object {
        fun getSortList(): List<SortType> {
            return SortType::class.sealedSubclasses
                .map { kClass ->
                    kClass.objectInstance
                }
                .filterIsInstance<SortType>()
        }
    }
}


//Always one sort option is chosen and this can be best match, newest,
//rating average, distance, popularity, average product price, delivery costs or the
//minimum cost. (Values available in sample.json)
object BestMatch : SortType("BestMatch")
object Newest : SortType("Newest")
object RatingAverage : SortType("RatingAverage")
object Distance : SortType("Distance")
object Popularity : SortType("Popularity")
object AverageProductPrice : SortType("AverageProductPrice")
object DeliveryCost : SortType("DeliveryCost")
object MinimumCost : SortType("MinimumCost")
object Status : SortType("Status")