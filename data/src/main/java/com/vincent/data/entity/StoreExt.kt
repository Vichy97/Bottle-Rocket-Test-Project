package com.vincent.data.entity

import com.vincent.network.entity.response.StoresResponse

fun StoresResponse.Store.toStore(): Store {
    val address = Address(
        street = address,
        city = city,
        state = state,
        zipCode = zipCode
    )
    val coordinates = Coordinates(latitude = latitude, longitude = longitude)

    return Store(
        id = id,
        name = name,
        phone = phone,
        logoUrl = logoUrl,
        address = address,
        coordinates = coordinates
    )
}