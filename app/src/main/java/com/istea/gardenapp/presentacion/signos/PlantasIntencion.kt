package com.istea.gardenapp.presentacion.signos

import com.istea.gardenapp.repository.Planta

sealed class PlantasIntencion {
    object CargarLista : PlantasIntencion()
    data class Seleccionar(val planta: Planta) : PlantasIntencion()
}

