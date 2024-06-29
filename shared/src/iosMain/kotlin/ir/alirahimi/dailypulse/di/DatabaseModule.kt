package ir.alirahimi.dailypulse.di

import ali.rahimi.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import ir.alirahimi.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}