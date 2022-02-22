package com.vik.scoober.domain.usecase

import com.vik.scoober.domain.Repository
import com.vik.scoober.domain.model.Restraurant
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetRestaurantListUseCaseImplTest{

    private val repo = mock<Repository>()
    private val sut = GetRestaurantListUseCaseImpl(repo)

    @Test
    fun `invoke should return list of Restaurant for success from repo`(){
       runBlocking {
           val mockRestaurantList = mock<List<Restraurant>>()
           whenever(repo.getRestaurants()).thenReturn(Result.success(mockRestaurantList))
            Assert.assertEquals(sut.invoke(),mockRestaurantList)
       }

    }


    @Test
    fun `invoke should return emptyList of Restaurant for failure from repo`(){
       runBlocking {
           whenever(repo.getRestaurants()).thenReturn(Result.failure(Exception("error")))
            assert(sut.invoke().isEmpty())
       }

    }




}