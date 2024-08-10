package edu.udb.calculadoraapp

class Calculadora {
    fun sumar (a: Double, b: Double): Double{
        return a + b
    }

    fun restar (a: Double, b: Double): Double{
        return a - b
    }

    fun multiplicar (a: Double, b: Double): Double{
        return a * b
    }

    fun dividir (a: Double, b: Double): Double{
        if (b == 0.0){
            throw IllegalArgumentException("No se puede dividir por cifra cero")
        }
        return a / b
    }
}