package dev.adryanev.sprint.interviewsprint.data.repository.impl

import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import dev.adryanev.sprint.interviewsprint.data.helpers.JsonHelper
import dev.adryanev.sprint.interviewsprint.data.repository.DestinationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DestinationRepositoryImpl @Inject constructor(val jsonHelper: JsonHelper) : DestinationRepository {

    override suspend fun getDestinations(): Flow<List<Destination>?> {
        return flow {
            val data = jsonHelper.parseDestinationJson()
            emit(data?.data?.content)
        }
    }
}