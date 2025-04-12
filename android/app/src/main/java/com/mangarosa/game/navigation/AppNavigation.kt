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
        composable(Routes.TABULEIRO) {
            TabuleiroScreen()
        }
        composable(Routes.PARTICIPANTE) {
            ParticipantesScreen(
                onNavigate = navController::navigate
            )
        }
    }
}