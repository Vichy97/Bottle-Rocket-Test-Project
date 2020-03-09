package com.vincent.ui.store_details

import android.content.res.Resources
import androidx.lifecycle.ViewModel

import com.vincent.core_ui.base.NavigationEvent
import com.vincent.data.entity.Store
import com.vincent.data.repository.StoreRepository
import com.vincent.ui.R
import com.vincent.util.RxProvider

import timber.log.Timber

import java.net.SocketTimeoutException
import java.net.UnknownHostException


internal class StoreDetailsViewModel(
    private val storeId: String,
    private val rxProvider: RxProvider,
    private val storeRepository: StoreRepository,
    private val resources: Resources
) : ViewModel() {

    private val compositeDisposable = rxProvider.compositeDisposable()

    val viewStateEvents = rxProvider.behaviorSubject<StoreDetailsViewState>()

    init {
        fetchStore()
    }

    private fun fetchStore() {
        val disposable = storeRepository.getStoreById(storeId)
            .doOnSubscribe { viewStateEvents.onNext(StoreDetailsViewState(loading = true)) }
            .subscribeOn(rxProvider.ioScheduler())
            .subscribe({ onFetchStoreSuccess(it) }, { onFetchStoreError(it) })
        compositeDisposable.add(disposable)
    }

    private fun onFetchStoreSuccess(store: Store) {
        viewStateEvents.onNext(StoreDetailsViewState(store = store))
    }

    private fun onFetchStoreError(throwable: Throwable) {
        Timber.e(throwable)

        val error = when (throwable) {
            is SocketTimeoutException, is UnknownHostException -> {
                resources.getString(R.string.internet_connection_error)
            }
            else -> resources.getString(R.string.generic_error)
        }

        viewStateEvents.onNext(StoreDetailsViewState(error = error))
    }
}