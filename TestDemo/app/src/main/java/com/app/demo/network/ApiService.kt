package com.app.demo.network

import com.app.demo.model.PeopleModel
import com.app.demo.model.RoomsModel
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkingConstants.URL_PEOPLE)
    suspend fun getPeople(): PeopleModel


    @GET(NetworkingConstants.URL_ROOMS)
    suspend fun getRoom(): RoomsModel
}