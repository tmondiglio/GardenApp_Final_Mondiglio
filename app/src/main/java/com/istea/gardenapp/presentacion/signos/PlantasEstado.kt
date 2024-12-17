package com.istea.gardenapp.presentacion.signos

import com.istea.gardenapp.repository.Planta

sealed class PlantasEstado {
    data object Vacio: PlantasEstado()
    data object Cargando: PlantasEstado()
    data class Resultado( val plantas : List<Planta> ) :PlantasEstado()
    data class Error(val mensaje: String): PlantasEstado()
}