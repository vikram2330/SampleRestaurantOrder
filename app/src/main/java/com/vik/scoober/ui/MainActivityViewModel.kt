package com.vik.scoober.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.domain.model.SortType
import com.vik.scoober.domain.model.Status
import com.vik.scoober.domain.usecase.GetRestaurantListUseCase
import com.vik.scoober.domain.usecase.SearchRestaurantUseCase
import com.vik.scoober.domain.usecase.SortBySortingValueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getRestaurantListUseCase: GetRestaurantListUseCase,
    private val sortUseCase: SortBySortingValueUseCase,
    private val searchRestaurantUseCase: SearchRestaurantUseCase
) : ViewModel() {

    private val restaurantListLiveData = MutableLiveData<List<Restraurant>>()
    val restaurantListData: MutableLiveData<List<Restraurant>> = restaurantListLiveData
    private var currentSortType: SortType = Status
    private val sortingOptions: List<SortType> = SortType.getSortList()

    fun getRestaurants() {
        viewModelScope.launch {
            val list = getRestaurantListUseCase()
            restaurantListLiveData.postValue(sortUseCase(list, currentSortType))
        }
    }

    fun setSortType(selectedItemPosition: Int) {
        currentSortType = sortingOptions[selectedItemPosition]
        restaurantListLiveData.value?.let { list ->
            viewModelScope.launch {
                restaurantListLiveData.postValue(sortUseCase(list, currentSortType))
            }
        }
    }

    fun searchList(searchText: String) {
        viewModelScope.launch {
            val list = searchRestaurantUseCase(searchText)
            restaurantListLiveData.postValue(sortUseCase(list, currentSortType))
        }
    }

    fun getSortingTypeList():List<String>{
        return  sortingOptions.map { it.name }
    }

    fun getCurrentSelectPosition():Int{
        return  sortingOptions.indexOf(currentSortType)
    }


}