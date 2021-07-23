package dev.adryanev.sprint.interviewsprint.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dev.adryanev.sprint.interviewsprint.data.repository.DestinationRepository
import dev.adryanev.sprint.interviewsprint.data.repository.HotelRepository
import dev.adryanev.sprint.interviewsprint.data.repository.impl.DestinationRepositoryImpl
import dev.adryanev.sprint.interviewsprint.data.repository.impl.HotelRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDestinationRepository(destinationRepository: DestinationRepositoryImpl): DestinationRepository

    @Binds
    @ViewModelScoped
    abstract fun bindHotelRepository(hotelRepository: HotelRepositoryImpl): HotelRepository
}