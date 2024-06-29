package ir.alirahimi.dailypulse.android

import android.app.Application
import ir.alirahimi.dailypulse.android.di.databaseModule
import ir.alirahimi.dailypulse.android.di.viewModelsModule
import ir.alirahimi.dailypulse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}