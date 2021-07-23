package dev.adryanev.sprint.interviewsprint.data.factory

import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun createDestinationList(): List<Destination>{
   val data = createDestination()
    return arrayListOf(data, data)
}

fun createDestinationFlow(): Flow<List<Destination>?>{
    return flow{
        emit(createDestinationList())
    }
}

fun createDestination(): Destination {
    return Destination(
        areaId="Z1Y4bnJHTURySEM2aHMvMktRMWVrUT09",
        countryId="WU83TVU3ZzAvMnFzeTM5RXAxQ0hXdz09",
        areaName="Semarang",
        areaCode="SRG",
        areaPhoto= "https://prodtest.gaidz.id/images/area/area-1572711673.jpeg",
        latitude="-6.9904038",
        longitude="110.4229455",
        countryName="Indonesia",
        countryCode="ID"
    )
}
