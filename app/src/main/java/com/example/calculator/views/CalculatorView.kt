import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel =  CalculatorViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Calculadora de Descuentos",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Mostrar el precio total con descuento
            Text(
                text = "Precio: $${"%.2f".format(viewModel.precioFinal)}",
                style = MaterialTheme.typography.bodyLarge,

                modifier = Modifier
                    .background(Color(0xFF848484))
                    .padding(16.dp)
            )
            // Mostrar el descuento total
            Text(
                text = "Descuento: $${"%.2f".format(viewModel.descuentoTotal)}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .background(Color(0xFF848484))
                    .padding(16.dp)

            )
            // Campo de texto para el precio
            TextField(
                value = viewModel.precio,
                onValueChange = { viewModel.onPrecioChange(it) },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo de texto para el descuento
            TextField(
                value = viewModel.descuento,
                onValueChange = { viewModel.onDescuentoChange(it) },
                label = { Text("Descuento") },
                modifier = Modifier.fillMaxWidth()
            )
            // Boton para calcular el descuento
            Button(
                onClick = { viewModel.calcularDescuento() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }

            // Boton para limpiar los campos
            Button(
                onClick = { viewModel.limpiarCampos() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Limpiar")
            }
        }
    }
}

