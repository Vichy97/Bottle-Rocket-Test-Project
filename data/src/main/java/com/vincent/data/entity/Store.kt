package com.vincent.data.entity

data class Store(
    val id: String = "",
    val name: String = "",
    val phone: String = "",
    val logoUrl: String = "",
    val address: Address = Address(),
    val coordinates: Coordinates = Coordinates()
)