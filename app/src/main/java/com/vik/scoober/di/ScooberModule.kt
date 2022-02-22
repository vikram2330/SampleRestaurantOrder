package com.vik.scoober.di

import android.app.Application
import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vik.scoober.data.RepositoryImpl
import com.vik.scoober.data.mapper.RestaurantMapper
import com.vik.scoober.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object ScooberModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideAssets(application: Application): AssetManager {
        return application.assets
    }

    @Provides
    fun provideRepository(
        restaurantMapper: RestaurantMapper,
        assetManager: AssetManager,
        moshi: Moshi,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): Repository {
        return RepositoryImpl(restaurantMapper, assetManager, moshi, dispatcher)
    }

}