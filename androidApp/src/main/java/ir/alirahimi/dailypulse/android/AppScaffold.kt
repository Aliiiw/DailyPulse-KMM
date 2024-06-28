package ir.alirahimi.dailypulse.android

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.alirahimi.dailypulse.android.screens.AboutScreen
import ir.alirahimi.dailypulse.android.screens.ArticlesScreen
import ir.alirahimi.dailypulse.android.screens.Screens
import ir.alirahimi.dailypulse.articles.ArticlesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold() {

    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen{ navController.navigate(Screens.ABOUT.route) }
        }

        composable(Screens.ABOUT.route) {
            AboutScreen { navController.popBackStack() }
        }
    }
}