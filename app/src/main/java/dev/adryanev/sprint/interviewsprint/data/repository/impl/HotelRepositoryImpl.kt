package dev.adryanev.sprint.interviewsprint.data.repository.impl

import dev.adryanev.sprint.interviewsprint.data.entity.Hotel
import dev.adryanev.sprint.interviewsprint.data.helpers.JsonHelper
import dev.adryanev.sprint.interviewsprint.data.repository.HotelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(val jsonHelper: JsonHelper): HotelRepository {

    override suspend fun getHotels(): Flow<List<Hotel>?> {
        return flow {
            val data = jsonHelper.parseHotelJson()
            emit(data?.data?.content)
        }
    }
}