package com.example.composejetpack

import android.app.Application
import com.example.composejetpack.data.repositoryModules
import com.example.composejetpack.data.serviceModules
import com.example.composejetpack.data.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModules,
                    repositoryModules,
                    serviceModules
                )
            )
        }
    }
}