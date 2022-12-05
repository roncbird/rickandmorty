package com.example.rickandmorty

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.navigation.DefaultNavigationViewModelDelegateFactory
import com.example.rickandmorty.koin.NetModule
import com.example.rickandmorty.koin.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Mavericks.initialize(
            debugMode = BuildConfig.DEBUG,
            viewModelDelegateFactory = DefaultNavigationViewModelDelegateFactory(),
        )

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(
                NetModule,
                RepositoryModule,
            )
        }

    }

}