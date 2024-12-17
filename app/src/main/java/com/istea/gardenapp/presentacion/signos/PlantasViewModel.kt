package com.istea.gardenapp.presentacion.signos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.gardenapp.repository.Repository
import com.istea.gardenapp.repository.Planta
import com.istea.gardenapp.router.Router
import com.istea.gardenapp.router.Ruta
import kotlinx.coroutines.launch

class PlantasViewModel(
    val repositorio: Repository,
    val router: Router
) : ViewModel() {

    var uiState by mutableStateOf<PlantasEstado>(PlantasEstado.Vacio)

    fun ejecutar(intencion: PlantasIntencion) {
        when(intencion){
            is PlantasIntencion.CargarLista -> cargarLista()
            is PlantasIntencion.Seleccionar -> seleccionar(planta = intencion.planta)
        }
    }

    private fun cargarLista(){
        uiState = PlantasEstado.Cargando
        viewModelScope.launch {
            val plantas = repositorio.getPlantas()
            uiState = PlantasEstado.Resultado(plantas)
        }
    }

    private fun seleccionar(planta: Planta){
        router.navegar(Ruta.Detalle(planta))
    }
}

class SignosViewModelFactory(
    private val repositorio: Repository,
    private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlantasViewModel::class.java)) {
            return PlantasViewModel(repositorio,router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}