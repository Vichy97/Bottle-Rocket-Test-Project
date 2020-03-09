package com.vincent.data.repository

import com.vincent.data.entity.Store
import com.vincent.data.entity.toStore
import com.vincent.network.api.StoreApi

import io.reactivex.Single

class StoreRepository(private val storeApi: StoreApi) {

    fun getStores(): Single<List<Store>> = storeApi.getStores()
        .flattenAsObservable { it.stores }
        .map { it.toStore() }
        .toList()

    fun getStoreById(id: String) = storeApi.getStores()
        .flattenAsObservable { it.stores }
        .filter { it.id == id }
        .map { it.toStore() }
        .firstOrError()!!
}