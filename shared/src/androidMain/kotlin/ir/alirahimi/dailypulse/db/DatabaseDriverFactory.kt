package ir.alirahimi.dailypulse.db

import ali.rahimi.dailypulse.db.DailyPulseDatabase
import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ir.alirahimi.dailypulse.utils.Constants

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(DailyPulseDatabase.Schema, context, Constants.DATABASE_NAME)

}