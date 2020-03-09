package com.vincent.ui.store_details

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.squareup.picasso.Picasso

import com.vincent.core_ui.base.BaseFragment
import com.vincent.data.entity.Coordinates
import com.vincent.ui.R
import com.vincent.ui.store_details.ARGS.STORE_ID
import com.vincent.util.RxProvider

import kotlinx.android.synthetic.main.fragment_store_details.*

import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

object ARGS {
    const val STORE_ID = "ARG_STORE_ID"
}

class StoreDetailsFragment : BaseFragment(
    layoutId = R.layout.fragment_store_details,
    module = storeDetailsModule
), OnMapReadyCallback {

    private val viewModel: StoreDetailsViewModel by viewModel { parametersOf(requireArguments()[STORE_ID]) }
    private val rxProvider: RxProvider by inject()
    private val compositeDisposable = rxProvider.compositeDisposable()

    private lateinit var map: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        map_view.onCreate(savedInstanceState)
        map_view.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        map.uiSettings.setAllGesturesEnabled(false)
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        val disposable = viewModel.viewStateEvents
            .observeOn(rxProvider.uiScheduler())
            .subscribe { onViewStateEvent(it) }

        compositeDisposable.add(disposable)
    }

    private fun onViewStateEvent(viewState: StoreDetailsViewState) {
        loading_indicator.isVisible = viewState.loading

        viewState.error?.let {
            return showSnackbar(it)
        }

        viewState.store ?: return

        tv_name.text = viewState.store.name
        tv_address.text = viewState.store.address.toString()
        tv_phone.text = viewState.store.phone

        setLogo(viewState.store.logoUrl)
        addMapMarker(viewState.store.name, viewState.store.coordinates)
    }

    private fun setLogo(url: String) {
        Picasso.get()
            .load(url)
            .resizeDimen(R.dimen.logo_width, R.dimen.logo_height)
            .centerInside()
            .into(iv_logo)
    }

    private fun addMapMarker(name: String, coordinates: Coordinates) {
        val latLng = LatLng(coordinates.latitude.toDouble(), coordinates.longitude.toDouble())
        map.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(name)
        )
        val positionUpdate = CameraUpdateFactory
            .newLatLng(latLng)
        val zoomUpdate = CameraUpdateFactory.zoomTo(15f)
        map.moveCamera(positionUpdate)
        map.moveCamera(zoomUpdate)
    }

    override fun onStart() {
        super.onStart()

        map_view.onStart()
    }

    override fun onResume() {
        super.onResume()

        map_view.onResume()
    }

    override fun onPause() {
        super.onPause()

        map_view.onPause()
    }

    override fun onStop() {
        super.onStop()

        map_view.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        map_view.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()

        map_view.onLowMemory()
    }

    override fun onDestroyView() {
        compositeDisposable.clear()

        map_view.onDestroy()

        super.onDestroyView()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()

        super.onDestroy()
    }
}