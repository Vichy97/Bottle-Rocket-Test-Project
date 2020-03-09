package com.vincent.network.api

import com.vincent.network.entity.response.StoresResponse
import io.reactivex.Single
import retrofit2.http.GET

interface StoreApi {

    @GET("stores.json")
    fun getStores(): Single<StoresResponse>
}