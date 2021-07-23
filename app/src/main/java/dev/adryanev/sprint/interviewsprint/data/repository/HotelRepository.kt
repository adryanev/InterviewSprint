package dev.adryanev.sprint.interviewsprint.data.repository

import dev.adryanev.sprint.interviewsprint.data.entity.Hotel
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun getHotels(): Flow<List<Hotel>?>
}