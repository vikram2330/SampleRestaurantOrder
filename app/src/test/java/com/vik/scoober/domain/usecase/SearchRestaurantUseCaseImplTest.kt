package com.vik.scoober.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class SearchRestaurantUseCaseImplTest {
    private val getRestaurantListUseCase = mock<GetRestaurantListUseCase>()
    private val sut = SearchRestaurantUseCaseImpl(getRestaurantListUseCase)

    @Test
    fun `invoke should return filtered list for given value`() {
        runBlocking {
            val searchKeyword = "abc"
            whenever(getRestaurantListUseCase.invoke()).thenReturn(ListProvider.getListForSearch())
            assert(sut.invoke("abc").isNotEmpty())
            sut.invoke(searchKeyword).forEach {
                assert(it.name == searchKeyword)
            }
        }
    }

}