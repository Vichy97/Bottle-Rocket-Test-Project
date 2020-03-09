package com.vincent.ui.stores

import android.content.res.Resources
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.vincent.core_ui.base.NavigationEvent
import com.vincent.data.entity.Store
import com.vincent.data.repository.StoreRepository
import com.vincent.ui.R
import com.vincent.ui.store_details.ARGS
import com.vincent.util.RxProvider
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException

internal class StoresViewModel(
    private val rxProvider: RxProvider,
    private val storeRepository: StoreRepository,
    private val resources: Resources
) : ViewModel() {

    val viewStateEvents = rxProvider.behaviorSubject<StoresViewState>()
    val navigationEvents = rxProvider.publishSubject<NavigationEvent>()

    private val compositeDisposable = rxProvider.compositeDisposable()

    init {
        viewStateEvents.onNext(StoresViewState(loading = true))
        getStores()
    }

    fun refresh() {
        getStores()
    }

    fun onQueryTextChanged(query: String) {
        viewStateEvents.onNext(StoresViewState(loading = true))
        getStores(query)
    }

    private fun getStores(query: String = "") {
        val disposable = storeRepository.getStores()
            .flattenAsObservable { it }
            .filter {
                return@filter if (query.isEmpty()) {
                    true
                } else {
                    it.name.contains(query, ignoreCase = true) ||
                            it.address.toString().contains(query, ignoreCase = true)
                }
            }
            .toList()
            .subscribeOn(rxProvider.ioScheduler())
            .subscribe({ onGetStoresSuccess(it) }, { onGetStoresError(it) })
        compositeDisposable.add(disposable)
    }

    private fun onGetStoresSuccess(stores: List<Store>) {
        viewStateEvents.onNext(StoresViewState(stores = stores))
    }

    private fun onGetStoresError(throwable: Throwable) {
        Timber.e(throwable)

        val error = when (throwable) {
            is SocketTimeoutException, is UnknownHostException -> {
                resources.getString(R.string.internet_connection_error)
            }
            else -> resources.getString(R.string.generic_error)
        }

        viewStateEvents.onNext(StoresViewState(error = error))
    }

    fun onStoreClicked(storeId: String) {
        val args = bundleOf(ARGS.STORE_ID to storeId)
        val navEvent = NavigationEvent(R.id.action_storesFragment_to_storeDetailsFragment, args)

        navigationEvents.onNext(navEvent)
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}