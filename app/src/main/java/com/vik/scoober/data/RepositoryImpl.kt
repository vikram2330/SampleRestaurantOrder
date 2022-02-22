package com.vik.scoober.data

import android.content.res.AssetManager
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.vik.scoober.data.mapper.RestaurantMapper
import com.vik.scoober.data.model.RestaurantResponseDTO
import com.vik.scoober.di.IoDispatcher
import com.vik.scoober.domain.Repository
import com.vik.scoober.domain.model.Restraurant
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val restaurantMapper: RestaurantMapper,
    private val assetManager: AssetManager,
    private val moshi: Moshi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {

    override suspend fun getRestaurants(): Result<List<Restraurant>> {
        return withContext(ioDispatcher) {
            try {
                val adapter: JsonAdapter<RestaurantResponseDTO> =
                    moshi.adapter(RestaurantResponseDTO::class.java)
                Log.d("repo", "adapter created")
                val file = "data.json"

                val jsonBlock = assetManager.open(file).bufferedReader().use { it.readText() }
                Log.d("repo", jsonBlock)
                val list: List<Restraurant> = adapter.fromJson(jsonBlock)?.restaurants?.map {
                    restaurantMapper.map(it)
                } ?: emptyList()
                Result.success<List<Restraurant>>(list)
            } catch (ex: Exception) {
                Result.failure(ex)
            }
        }
    }
}