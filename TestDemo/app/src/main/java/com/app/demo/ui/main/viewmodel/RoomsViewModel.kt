package com.app.demo.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.app.demo.model.PeopleModel
import com.app.demo.model.RoomsModel
import com.app.demo.network.ResultData
import com.app.demo.usecase.PeopleDataUseCase
import com.app.demo.usecase.RoomsDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class RoomsViewModel @ViewModelInject constructor(
    private val roomsDataUseCase: RoomsDataUseCase
): ViewModel() {
    fun getRoomsRepositoriesList(since: String): LiveData<ResultData<RoomsModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(roomsDataUseCase.getRoomsRepositoriesList())
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }
}