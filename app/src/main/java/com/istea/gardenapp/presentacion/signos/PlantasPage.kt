package com.istea.gardenapp.presentacion.signos

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.gardenapp.repository.Repository
import com.istea.gardenapp.router.Router

@Composable
fun PlantasPage(
    navHostController: NavHostController
) {
    val viewModel : PlantasViewModel = viewModel(
        factory = SignosViewModelFactory(
            repositorio = Repository(),
            router = Router(navHostController)
        )
    )
    PlantasView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}
