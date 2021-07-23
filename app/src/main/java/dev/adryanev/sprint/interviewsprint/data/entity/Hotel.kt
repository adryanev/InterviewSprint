package dev.adryanev.sprint.interviewsprint.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hotel(

	@Json(name="redemptionInformation")
	val redemptionInformation: String? = null,

	@Json(name="reservationInformation")
	val reservationInformation: String? = null,

	@Json(name="cancelationPolicy")
	val cancelationPolicy: String? = null,

	@Json(name="validities")
	val validities: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="validityInformation")
	val validityInformation: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="referenceId")
	val referenceId: String? = null,

	@Json(name="noted")
	val noted: String? = null,

	@Json(name="duration")
	val duration: String? = null,

	@Json(name="validateTime")
	val validateTime: String? = null,

	@Json(name="termAndCondition")
	val termAndCondition: String? = null,

	@Json(name="referenceImage")
	val referenceImage: String? = null,

	@Json(name="isRecomended")
	val isRecomended: Int? = null,

	@Json(name="value")
	val value: List<String?>? = null,

	@Json(name="ticketId")
	val ticketId: String? = null,

	@Json(name="referenceName")
	val referenceName: String? = null,

	@Json(name="ticketName")
	val ticketName: String? = null
)
