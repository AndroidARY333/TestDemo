package com.app.demo.di

import com.app.demo.network.ApiService
import com.app.demo.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepository(apiService)
    }
}