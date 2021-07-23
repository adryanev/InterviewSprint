package dev.adryanev.sprint.interviewsprint.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import dev.adryanev.sprint.interviewsprint.data.entity.Hotel

@JsonClass(generateAdapter = true)
data class DataDestination(
	@Json(name="total")
	val total: Int? = null,
	@Json(name="totalPaging")
	val totalPaging: Int? = null,
	@Json(name="content")
	val content: List<Destination>? = null
) : BaseResponse()