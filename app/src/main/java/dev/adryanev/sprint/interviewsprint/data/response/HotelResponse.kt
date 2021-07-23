package dev.adryanev.sprint.interviewsprint.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class HotelResponse(
    @Json(name = "code")
    val code: Int? = null,

    @Json(name = "data")
    val data: DataHotel? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "status")
    val status: Boolean? = null
)