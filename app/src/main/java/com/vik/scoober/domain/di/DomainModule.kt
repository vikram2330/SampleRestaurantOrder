package com.vik.scoober.domain.di

import com.vik.scoober.di.IoDispatcher
import com.vik.scoober.domain.Repository
import com.vik.scoober.domain.usecase.GetRestaurantListUseCase
import com.vik.scoober.domain.usecase.GetRestaurantListUseCaseImpl
import com.vik.scoober.domain.usecase.SearchRestaurantUseCase
import com.vik.scoober.domain.usecase.SearchRestaurantUseCaseImpl
import com.vik.scoober.domain.usecase.SortBySortingValueUseCase
import com.vik.scoober.domain.usecase.SortBySortingValueUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetRestaurantListUseCase(repository: Repository): GetRestaurantListUseCase {
        return GetRestaurantListUseCaseImpl(repository)
    }

    @Provides
    fun provideSortBySortingValueUseCase(@IoDispatcher dispatcher: CoroutineDispatcher): SortBySortingValueUseCase {
        return SortBySortingValueUseCaseImpl(dispatcher)
    }
    @Provides
    fun provideSearchRestaurantUseCase(getRestaurantListUseCase: GetRestaurantListUseCase): SearchRestaurantUseCase {
        return SearchRestaurantUseCaseImpl(getRestaurantListUseCase)
    }
}