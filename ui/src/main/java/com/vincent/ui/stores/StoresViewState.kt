package com.vincent.ui.stores

import com.vincent.data.entity.Store

internal data class StoresViewState(
    val stores: List<Store> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)