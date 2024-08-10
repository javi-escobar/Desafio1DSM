package edu.udb.calculadoraapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val operando1 = findViewById<EditText>(R.id.operando1)
        val operando2 = findViewById<EditText>(R.id.operando2)
        val operacion = findViewById<Spinner>(R.id.operacion)
        val calcular = findViewById<Button>(R.id.calcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        val calculadora = Calculadora()

        val operaciones = arrayOf("Suma", "Resta", "Multiplicación", "División")
        operacion.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operaciones)

        calcular.setOnClickListener {
            val valor1 = operando1.text.toString().toDouble()
            val valor2 = operando2.text.toString().toDouble()
            val operacionSeleccionada = operacion.selectedItem.toString()

            val resultadoOperacion = when (operacionSeleccionada) {
                "Suma" -> calculadora.sumar(valor1, valor2)
                "Resta" -> calculadora.restar(valor1, valor2)
                "Multiplicación" -> calculadora.multiplicar(valor1, valor2)
                "División" -> calculadora.dividir(valor1, valor2)
                else -> 0.0
            }

            resultado.text = "Resultado: $resultadoOperacion"
        }

        }
    }
