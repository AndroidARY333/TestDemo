package com.app.demo.usecase

import com.app.demo.model.PeopleModel
import com.app.demo.model.RoomsModel
import com.app.demo.network.ResultData
import com.app.demo.repository.DataRepository
import javax.inject.Inject

class RoomsDataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getRoomsRepositoriesList(): ResultData<RoomsModel> {
        val repositoriesModel = dataRepository.getRoomsPeopleList()

        val resultData = when(repositoriesModel.isNotEmpty()) {
            true -> {
                ResultData.Success(repositoriesModel)
            }
            else -> {
                ResultData.Failed()
            }
        }
        return resultData
    }
}