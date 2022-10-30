package com.app.demo.usecase

import com.app.demo.model.PeopleModel
import com.app.demo.network.ResultData
import com.app.demo.repository.DataRepository
import javax.inject.Inject

class PeopleDataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getPeopleRepositoriesList(): ResultData<PeopleModel> {
        val repositoriesModel = dataRepository.getRepositoriesPeopleList()

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