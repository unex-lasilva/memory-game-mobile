package com.mangarosa.game.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mangarosa.game.models.Tabuleiro
import com.mangarosa.game.ui.screens.ParticipantesScreen
import com.mangarosa.game.ui.screens.TabuleiroOptionScreen
import com.mangarosa.game.ui.screens.TabuleiroScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MENU) {
        composable(Routes.MENU) {
            HomeScreen(
                onNavigate = navController::navigate
            )
        }
        composable(Routes.TABULEIRO_OPTION) {
            TabuleiroOptionScreen(
                onNavigate = navController::navigate
            )
        }

        composable("tabuleiro/{p1}/{p2}") { backStackEntry ->
                val p1 = backStackEntry.arguments?.getString("p1") ?: ""
                val p2 = backStackEntry.arguments?.getString("p2") ?: ""

                // Decodifica caso necessário
                val nome1 = java.net.URLDecoder.decode(p1, "UTF-8")
                val nome2 = java.net.URLDecoder.decode(p2, "UTF-8")

                TabuleiroScreen(nome1, nome2)


        }
        composable(Routes.PARTICIPANTE) {
            ParticipantesScreen(
                onNavigate = navController::navigate
            )
        }
    }
}