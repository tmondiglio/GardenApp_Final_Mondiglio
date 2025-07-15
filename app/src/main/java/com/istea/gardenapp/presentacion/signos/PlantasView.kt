package com.istea.gardenapp.presentacion.signos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.istea.gardenapp.R
import com.istea.gardenapp.repository.Planta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantasView (
    modifier: Modifier = Modifier,
    state : PlantasEstado,
    onAction: (PlantasIntencion)->Unit
) {

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(PlantasIntencion.CargarLista)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text(text = "GardenApp") }
            )
        }
    ) {
        Column(modifier = modifier.padding(it)) {
            when(state) {
                PlantasEstado.Cargando -> Text("...")
                is PlantasEstado.Error -> Text(text = state.mensaje)
                is PlantasEstado.Resultado ->
                    ListaDeSignosView(
                        state.searchText,
                        state.plantas,
                        onSearch = {
                            onAction(PlantasIntencion.Search(it))
                        }
                    ) {
                        onAction(
                            PlantasIntencion.Seleccionar(it)
                        )
                    }
                PlantasEstado.Vacio -> Text(text = "No hay plantas")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeSignosView(searchText:String, plantas: List<Planta>, onSearch: (String) -> Unit, onSelect: (Planta)->Unit){
    LazyColumn {
        item {
            OutlinedTextField(
                value = searchText,
                onValueChange = onSearch,
                label = { Text("Buscar") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
                    focusedLabelColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        items(items = plantas) { planta ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.secondary,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                onClick = {
                    onSelect(planta)
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(planta.ilustrationId),
                        contentDescription = planta.nombre,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .padding(10.dp),
                    )
                    Column {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.titleMedium,
                            text = planta.nombre
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            style = MaterialTheme.typography.titleSmall,
                            text = planta.temperatura
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            style = MaterialTheme.typography.titleSmall,
                            text = planta.sol
                        )
                        Text(
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            text = planta.descripcion
                        )
                    }
                }

            }
        }
    }
}