package com.istea.gardenapp.presentacion.detalle

import com.istea.gardenapp.repository.Cuidado

sealed class DetalleEstado {
    data object Vacio: DetalleEstado()
    data object Cargando: DetalleEstado()
    data class Resultado( val cuidado : Cuidado) :DetalleEstado()
    data class Error(val mensaje: String): DetalleEstado()
}