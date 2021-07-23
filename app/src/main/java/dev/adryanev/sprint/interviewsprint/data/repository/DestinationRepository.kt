package dev.adryanev.sprint.interviewsprint.data.repository

import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import kotlinx.coroutines.flow.Flow

interface DestinationRepository {

    suspend fun getDestinations(): Flow<List<Destination>?>
}