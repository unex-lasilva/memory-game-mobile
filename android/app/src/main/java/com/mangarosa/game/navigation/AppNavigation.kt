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
        composable("tabuleiro/{p1}/{p2}/{tamanho}") { backStackEntry ->
            val p1 = backStackEntry.arguments?.getString("p1") ?: ""
            val p2 = backStackEntry.arguments?.getString("p2") ?: ""
            val tamanho = backStackEntry.arguments?.getString("tamanho") ?:"4"


            val nome1 = java.net.URLDecoder.decode(p1, "UTF-8")
            val nome2 = java.net.URLDecoder.decode(p2, "UTF-8")

            TabuleiroScreen(
                nomeParticipante1 = nome1,
                nomeParticipante2 = nome2,
                tamanhoTabuleiro = tamanho.toInt(),
                onNavigate = navController::navigate
            )
        }
        composable("participante/{tamanho}") { backStackEntry ->
            val tamanho = backStackEntry.arguments?.getString("tamanho") ?: "4";

            ParticipantesScreen(
                tamanho = tamanho.toInt(),
                onNavigate = navController::navigate
            )
        }
    }
}