package com.vincent.store_locator

import android.app.Application
import com.vincent.data.repository.repositoryModule

import com.vincent.network.networkModule
import com.vincent.util.utilsModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

import timber.log.Timber

class Application : Application() {

    private val modules = listOf(
        utilsModule,
        networkModule,
        repositoryModule
    )

    override fun onCreate() {
        super.onCreate()

        setupLogging()
        setupDependencyInjection()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupDependencyInjection() {
        startKoin {
            androidContext(this@Application)
            modules(modules)
        }
    }
}