package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.domain.model.SortType

interface SortBySortingValueUseCase {
    suspend operator fun invoke(list: List<Restraurant>, sortType: SortType): List<Restraurant>
}