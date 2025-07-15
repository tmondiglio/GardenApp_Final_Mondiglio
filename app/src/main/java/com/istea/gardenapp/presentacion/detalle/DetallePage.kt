package com.istea.gardenapp.presentacion.detalle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.gardenapp.repository.Repository
import com.istea.gardenapp.router.Router

@Composable
fun DetallePage(
    navHostController: NavHostController,
    plantaID: String
) {
    val viewModel : DetalleViewModel = viewModel(
        factory = DetalleViewModelFactory(
            repositorio = Repository(),
            router = Router(navHostController),
            plantaID = plantaID
        )
    )
    LaunchedEffect(Unit) {
        viewModel.ejecutar(DetalleIntencion.CargarContenido)
    }
    DetalleView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

/// punto dos cambio
