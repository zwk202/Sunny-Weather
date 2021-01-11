package com.unnyweather.android.ui.place

import androidx.lifecycle.*

import com.unnyweather.android.logic.Repository
import com.unnyweather.android.logic.dao.PlaceDao
import com.unnyweather.android.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place)=Repository.savePlace(place)

    fun getSavedPlace()= PlaceDao.getSavedPlace()

    fun isPlaceSaved()= PlaceDao.isPlacesSaved()



}