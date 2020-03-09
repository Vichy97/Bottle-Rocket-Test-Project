package com.vincent.data.repository

import com.vincent.network.api.StoreApi
import org.koin.dsl.module

val repositoryModule = module {

    single<StoreRepository> {
        StoreRepository(get<StoreApi>())
    }
}