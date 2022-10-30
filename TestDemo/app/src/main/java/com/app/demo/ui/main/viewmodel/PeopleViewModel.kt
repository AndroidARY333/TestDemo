package com.app.demo.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.app.demo.model.PeopleModel
import com.app.demo.network.ResultData
import com.app.demo.usecase.PeopleDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class PeopleViewModel @ViewModelInject constructor(
    private val peopleDataUseCase: PeopleDataUseCase
): ViewModel() {
    fun getPeopleRepositoriesList(since: String): LiveData<ResultData<PeopleModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(peopleDataUseCase.getPeopleRepositoriesList())
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }
}