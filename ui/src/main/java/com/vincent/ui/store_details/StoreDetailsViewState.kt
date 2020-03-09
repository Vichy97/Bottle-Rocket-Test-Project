package com.vincent.ui.store_details

import com.vincent.data.entity.Store

data class StoreDetailsViewState(
    val store: Store? = null,
    val loading: Boolean = false,
    val error: String? = null
)