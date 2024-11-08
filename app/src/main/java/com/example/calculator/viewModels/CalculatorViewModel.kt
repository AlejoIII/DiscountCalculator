import android.app.AlertDialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    // Variables de estado para los campos de entrada
    var precio by mutableStateOf("")
    var descuento by mutableStateOf("")
    // Variables de estado para los resultados
    var precioFinal by mutableStateOf(0.0)
    var descuentoTotal by mutableStateOf(0.0)
    // Funcion para actualizar el precio ingresado
    fun onPrecioChange(newPrecio: String) {
        precio = newPrecio
    }
    // Funcion para actualizar el descuento ingresado
    fun onDescuentoChange(newDescuento: String) {
        descuento = newDescuento
    }
    // Funcion para calcular el descuento y el precio final
    fun calcularDescuento() {
        val precioNum = precio.toDoubleOrNull() ?: 0.0
        val descuentoNum = descuento.toDoubleOrNull() ?: 0.0

        descuentoTotal = precioNum * (descuentoNum / 100)
        precioFinal = precioNum - descuentoTotal
    }
    // Funcion para limpiar los campos
    fun limpiarCampos() {
        precio = ""
        descuento = ""
        precioFinal = 0.0
        descuentoTotal = 0.0
    }


}
