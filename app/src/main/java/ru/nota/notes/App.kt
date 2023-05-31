package ru.nota.notes

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

import ru.nota.notes.di.dbModule
import ru.nota.notes.di.uiModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(uiModule, dbModule))
        }
    }
}