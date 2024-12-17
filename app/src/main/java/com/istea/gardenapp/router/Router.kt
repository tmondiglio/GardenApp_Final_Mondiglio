package com.istea.gardenapp.router

import androidx.navigation.NavHostController
import com.istea.gardenapp.repository.Planta


class Router(
    val navHostController: NavHostController
) {
    fun navegar(ruta: Ruta) {
        when(ruta){
            Ruta.Plantas -> navHostController.navigate(ruta.id)
            is Ruta.Detalle -> {
                val route = String.format(format="%s/%s",ruta.id,ruta.planta.signoId)
                navHostController.navigate(route)
            }
        }
    }

    fun back(){
        navHostController.popBackStack()
    }
}

sealed class Ruta(val id: String) {
    data object Plantas: Ruta("plantas")
    data class Detalle(val planta: Planta): Ruta("detalle")
}
