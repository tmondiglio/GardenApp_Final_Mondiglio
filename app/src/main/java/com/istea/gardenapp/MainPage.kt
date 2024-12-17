package com.istea.gardenapp;

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.istea.gardenapp.presentacion.detalle.DetallePage
import com.istea.gardenapp.presentacion.signos.PlantasPage
import com.istea.gardenapp.router.Ruta

@Composable
fun MainPage() {
    val navHostController = rememberNavController()
    NavHost(
            navController = navHostController,
            startDestination = "plantas"
    ) {
        composable(
                route = Ruta.Plantas.id
        ) {
            PlantasPage(navHostController)
        }
        composable(
                route = "detalle/{plantaID}",
                arguments =  listOf(
                    navArgument("plantaID") { type= NavType.StringType }
            )
        ) {
            val plantaID = it.arguments?.getString("plantaID") ?: ""
            DetallePage(navHostController, plantaID)
        }
    }
}