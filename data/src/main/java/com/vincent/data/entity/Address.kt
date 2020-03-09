package com.vincent.data.entity

data class Address(
    val street: String = "",
    val city: String = "",
    val state: String = "",
    val zipCode: String = ""
) {

    override fun toString(): String {
        return "$street,\n$city, $state $zipCode"
    }
}