package com.vincent.ui.stores

import android.content.res.Resources

import com.vincent.data.repository.StoreRepository
import com.vincent.util.RxProvider

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val storesModule = module {

    viewModel<StoresViewModel> {
        StoresViewModel(get<RxProvider>(), get<StoreRepository>(), get<Resources>())
    }
}