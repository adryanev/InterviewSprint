package dev.adryanev.sprint.interviewsprint.data.helpers

import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import dev.adryanev.sprint.interviewsprint.data.response.DestinationResponse
import dev.adryanev.sprint.interviewsprint.data.response.DestinationResponseJsonAdapter
import dev.adryanev.sprint.interviewsprint.data.response.HotelResponse
import dev.adryanev.sprint.interviewsprint.data.response.HotelResponseJsonAdapter
import javax.inject.Inject

class JsonHelper @Inject constructor(
    private val assetManager: AssetManager,
    private val moshi: Moshi
) {

    private fun parseJson(fileName: String): String {
        val json = assetManager.open(fileName).bufferedReader().use { it.readText() }
        return json
    }

    fun parseHotelJson(): HotelResponse? {

        val json = parseJson("hotel.json")
        val adapter = HotelResponseJsonAdapter(moshi)
        return adapter.fromJson(json)

    }

    fun parseDestinationJson(): DestinationResponse? {
        val json = parseJson("destination.json")
        val adapter = DestinationResponseJsonAdapter(moshi)
        return adapter.fromJson(json)
    }

}