package com.rfonzi.jotbubble

import android.app.Application
import com.rfonzi.libraries.persistence_inmemory.inMemoryModule
import org.koin.android.ext.android.bind
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class JotBubbleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val mainViewModelModule = module {
            viewModel { MainViewModel(get()) }
        }

        startKoin {
            androidContext(this@JotBubbleApp)

            modules(inMemoryModule)
            modules(mainViewModelModule)
        }


    }

}