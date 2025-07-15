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

    var searchText by mutableStateOf("")
    var plantas by mutableStateOf<List<Planta>>(emptyList())

    fun ejecutar(intencion: PlantasIntencion) {
        when(intencion){
            is PlantasIntencion.CargarLista -> cargarLista()
            is PlantasIntencion.Seleccionar -> seleccionar(planta = intencion.planta)
            is PlantasIntencion.Search -> search(searchText = intencion.searchText)
        }
    }

    private fun cargarLista(){
        uiState = PlantasEstado.Cargando
        viewModelScope.launch {
            plantas = repositorio.getPlantas()
            uiState = PlantasEstado.Resultado(plantas,searchText)
        }
    }

    private fun seleccionar(planta: Planta){
        router.navegar(Ruta.Detalle(planta))
    }

    private fun search(searchText: String){
        this.searchText = searchText
        val searchResult = plantas.filter {
            it.nombre.uppercase().contains(searchText.uppercase())
        }
        uiState = PlantasEstado.Resultado(searchResult, searchText)
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