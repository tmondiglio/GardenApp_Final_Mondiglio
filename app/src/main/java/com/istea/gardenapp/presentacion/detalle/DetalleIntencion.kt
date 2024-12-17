package com.istea.gardenapp.presentacion.detalle

sealed class DetalleIntencion {
    object IrParaAtras : DetalleIntencion()
    object CargarContenido: DetalleIntencion()
}

