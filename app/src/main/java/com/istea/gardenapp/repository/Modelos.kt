package com.istea.gardenapp.repository

import androidx.annotation.DrawableRes

data class Planta (
    val plantaId: String,
    val nombre: String,
    val descripcion: String,
    val temperatura: String,
    val sol: String,
    @DrawableRes val ilustrationId : Int
)

data class Cuidado (
    val planta: Planta,
    val riego: String,
    val poda: String,
    val propagacion: String,
)