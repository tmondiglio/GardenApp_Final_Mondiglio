package com.istea.gardenapp.presentacion.detalle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.istea.gardenapp.repository.Cuidado
import com.istea.gardenapp.repository.Planta


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleView (
    modifier: Modifier = Modifier,
    state : DetalleEstado,
    onAction: (DetalleIntencion)->Unit
) {

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(DetalleIntencion.CargarContenido)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text(text = "Cuidados") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onAction(DetalleIntencion.IrParaAtras)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }

                }
            )
        }
    ) {
        Column(modifier = modifier.padding(it)) {
            when (state) {
                DetalleEstado.Cargando -> Cargando()
                is DetalleEstado.Error -> Text(text = state.mensaje)
                is DetalleEstado.Resultado -> Contenido( state.cuidado )
                DetalleEstado.Vacio -> Text(text = "")
            }
        }
    }
}

@Composable
fun Cargando() {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier.size(160.dp),
            strokeWidth = 20.dp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
    }
}

@Composable
fun Contenido(cuidado: Cuidado){
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        DescripcionView(cuidado.planta)
        PrediccionView(titulo = "Riego", descripcion = cuidado.riego)
        PrediccionView(titulo = "Poda", descripcion = cuidado.poda)
        PrediccionView(titulo = "Propagacion", descripcion = cuidado.propagacion)
    }
}

@Composable
fun DescripcionView(planta: Planta){
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier.padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge,
                text = planta.nombre
            )
            Text(
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleSmall,
                text = planta.temperatura + " al " + planta.sol
            )
            Image(
                painterResource(planta.ilustrationId),
                contentDescription = planta.nombre,
                modifier = Modifier
                    .height(280.dp)
                    .fillMaxWidth()
                    .padding(20.dp)
            )

            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                text = planta.descripcion
            )
        }
    }
}

@Composable
fun PrediccionView(titulo:String, descripcion: String){
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = titulo
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                text = descripcion
            )
        }
    }
}
