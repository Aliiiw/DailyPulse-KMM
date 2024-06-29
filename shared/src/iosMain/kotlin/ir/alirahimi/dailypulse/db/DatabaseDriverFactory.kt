package ir.alirahimi.dailypulse.db

import ali.rahimi.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ir.alirahimi.dailypulse.utils.Constants

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(DailyPulseDatabase.Schema, Constants.DATABASE_NAME)

}