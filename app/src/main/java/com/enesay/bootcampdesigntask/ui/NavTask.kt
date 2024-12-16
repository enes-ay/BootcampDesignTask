package com.enesay.bootcampdesigntask.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enesay.bootcampdesigntask.Anasayfa

@Composable
fun NavTaskApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") { Anasayfa(navController) }
        composable("sayfaA") { SayfaA(navController) }
        composable("sayfaB") { SayfaB(navController) }
        composable("sayfaX") { SayfaX(navController) }
        composable("sayfaY") { SayfaY(navController) }
    }
}