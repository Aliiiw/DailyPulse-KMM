package ir.alirahimi.dailypulse.android.di

import ali.rahimi.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import ir.alirahimi.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }

}