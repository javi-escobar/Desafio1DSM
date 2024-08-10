package com.example.salario

data class Empleado(
    val nombre: String,
    val salarioBase: Double
) {
    // Función para calcular el descuento de AFP (7.25%)
    fun descuentoAFP(): Double {
        return salarioBase * 0.0725
    }

    // Función para calcular el descuento de ISSS (3%)
    fun descuentoISSS(): Double {
        return salarioBase * 0.03
    }

    // Función para calcular el descuento por la Renta
    fun descuentoRenta(): Double {
        return when {
            salarioBase <= 472.0 -> 0.0
            salarioBase <= 895.24 -> (salarioBase - 472) * 0.10 + 17.67
            salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.0
            else -> (salarioBase - 2038.10) * 0.30 + 288.57
        }
    }

    // Función para calcular el salario neto después de todos los descuentos
    fun salarioNeto(): Double {
        val descuentoAFP = descuentoAFP()
        val descuentoISSS = descuentoISSS()
        val descuentoRenta = descuentoRenta()
        val salarioNeto = salarioBase - (descuentoAFP + descuentoISSS + descuentoRenta)
        return String.format("%.2f", salarioNeto).toDouble()
    }
}
