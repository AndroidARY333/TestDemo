package com.app.demo.repository

import com.app.demo.model.PeopleModel
import com.app.demo.model.RoomsModel
import com.app.demo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getRepositoriesPeopleList(): PeopleModel {
        return apiService.getPeople()
    }

    suspend fun getRoomsPeopleList(): RoomsModel {
        return apiService.getRoom()
    }
}