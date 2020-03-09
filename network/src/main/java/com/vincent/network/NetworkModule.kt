package com.vincent.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vincent.network.api.StoreApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

private const val BASE_URL = "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/"

private const val CONNECT_TIMEOUT = 30L
private const val READ_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val CACHE_SIZE = 10 * 1024 * 1024

val networkModule = module {

    single<StoreApi> {
        get<Retrofit>().create(StoreApi::class.java)
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(get<MoshiConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            cache(get<Cache>())
        }.build()
    }

    single<Cache> {
        val cacheDir = File(androidApplication().cacheDir, "network_cache")
        Cache(cacheDir, CACHE_SIZE.toLong())
    }

    single<MoshiConverterFactory> {
        MoshiConverterFactory.create(get<Moshi>())
    }

    single<Moshi> {
        Moshi.Builder()
            .add(get<KotlinJsonAdapterFactory>())
            .build()
    }

    single<RxJava2CallAdapterFactory> {
        RxJava2CallAdapterFactory.create()
    }

    single<KotlinJsonAdapterFactory> {
        KotlinJsonAdapterFactory()
    }
}