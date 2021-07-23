package dev.adryanev.sprint.interviewsprint.data.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(

	@Json(name="areaCode")
	val areaCode: String? = null,

	@Json(name="areaPhoto")
	val areaPhoto: String? = null,

	@Json(name="areaId")
	val areaId: String? = null,

	@Json(name="areaName")
	val areaName: String? = null,

	@Json(name="countryCode")
	val countryCode: String? = null,

	@Json(name="latitude")
	val latitude: String? = null,

	@Json(name="countryName")
	val countryName: String? = null,

	@Json(name="countryId")
	val countryId: String? = null,

	@Json(name="longitude")
	val longitude: String? = null
) : Parcelable