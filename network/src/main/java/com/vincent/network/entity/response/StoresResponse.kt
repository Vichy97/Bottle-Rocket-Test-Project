package com.vincent.network.entity.response

import com.squareup.moshi.Json

data class StoresResponse(
    @Json(name = "stores")
    val stores: List<Store> = emptyList()
) {

    data class Store(
        @Json(name = "storeID")
        val id: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "storeLogoURL")
        val logoUrl: String = "",
        @Json(name = "phone")
        val phone: String = "",
        @Json(name = "address")
        val address: String = "",
        @Json(name = "city")
        val city: String = "",
        @Json(name = "state")
        val state: String = "",
        @Json(name = "zipcode")
        val zipCode: String = "",
        @Json(name = "longitude")
        val longitude: String = "",
        @Json(name = "latitude")
        val latitude: String = ""
    )
}