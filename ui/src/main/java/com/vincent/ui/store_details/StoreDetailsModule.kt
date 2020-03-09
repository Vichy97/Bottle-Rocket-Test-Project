package com.vincent.ui.store_details

import android.content.res.Resources

import com.vincent.data.repository.StoreRepository
import com.vincent.util.RxProvider

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val storeDetailsModule = module {

    viewModel<StoreDetailsViewModel> { (storeId: String) ->
        StoreDetailsViewModel(
            storeId,
            get<RxProvider>(),
            get<StoreRepository>(),
            get<Resources>()
        )
    }
}