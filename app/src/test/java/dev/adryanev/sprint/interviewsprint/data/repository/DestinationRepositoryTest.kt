package dev.adryanev.sprint.interviewsprint.data.repository

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.verify
import dev.adryanev.sprint.interviewsprint.data.factory.createDestination
import dev.adryanev.sprint.interviewsprint.data.factory.createDestinationFlow
import dev.adryanev.sprint.interviewsprint.utils.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.`when`
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
class DestinationRepositoryTest: BaseRepositoryTest() {

    val repository = mock<DestinationRepository>()
    val destinationData = createDestination()


    @ExperimentalTime
    @Test
    fun getDestinations() {

        testCoroutineRule.runBlockingTest {
            `when`(repository.getDestinations()).thenReturn(createDestinationFlow())

            val response = repository.getDestinations()
            verify(repository).getDestinations()

            launchTest {
                response.test(timeout = Duration.ZERO){
                    val data = expectItem()
                    assertNotNull(data)
                    assertEquals(2,data?.size)
                    assertEquals(destinationData, data?.get(0))
                }
            }
        }
    }
}