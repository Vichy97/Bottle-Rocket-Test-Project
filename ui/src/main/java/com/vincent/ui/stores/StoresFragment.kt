package com.vincent.ui.stores

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.vincent.core_ui.base.BaseFragment
import com.vincent.core_ui.base.NavigationEvent
import com.vincent.ui.R
import com.vincent.util.RxProvider
import kotlinx.android.synthetic.main.fragment_stores.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class StoresFragment : BaseFragment(
    layoutId = R.layout.fragment_stores,
    module = storesModule
), StoreAdapter.OnStoreClickedCallback, SearchView.OnQueryTextListener {

    private val viewModel: StoresViewModel by viewModel()
    private val rxProvider: RxProvider by inject()
    private val storeAdapter = StoreAdapter(this)
    private val navController: NavController by lazy { findNavController() }

    private val compositeDisposable = rxProvider.compositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = SearchView(context)
        item.actionView = searchView

        searchView.setOnQueryTextListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_stores.adapter = storeAdapter
        swipe_refresh.setOnRefreshListener { viewModel.refresh() }

        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        val viewStateDisposable = viewModel.viewStateEvents
            .observeOn(rxProvider.uiScheduler())
            .subscribe { onViewStateEvent(it) }
        val navigationDisposable = viewModel.navigationEvents
            .observeOn(rxProvider.uiScheduler())
            .subscribe { onNavigationEvent(it) }
        compositeDisposable.addAll(viewStateDisposable, navigationDisposable)
    }

    private fun onViewStateEvent(viewState: StoresViewState) {
        loading_indicator.isVisible = viewState.loading

        viewState.error?.let { return showSnackbar(it) }

        swipe_refresh.isRefreshing = false

        tv_no_stores.isVisible = viewState.stores.isEmpty()
        storeAdapter.setStores(viewState.stores)
    }

    private fun onNavigationEvent(navigationEvent: NavigationEvent) {
        navController.navigate(navigationEvent.id, navigationEvent.args)
    }

    override fun onDestroyView() {
        storeAdapter.clear()
        rv_stores.adapter = null
        compositeDisposable.clear()

        super.onDestroyView()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()

        super.onDestroy()
    }

    override fun onStoreClicked(storeId: String) {
        viewModel.onStoreClicked(storeId)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.onQueryTextChanged(newText)
        return true
    }
}