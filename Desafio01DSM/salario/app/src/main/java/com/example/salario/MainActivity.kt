package com.example.salario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputNombre: EditText = findViewById(R.id.inputNombre)
        val inputSalarioBase: EditText = findViewById(R.id.inputSalarioBase)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val txtSalarioNeto: TextView = findViewById(R.id.outputSalarioNeto)
        val txtNombre: TextView = findViewById(R.id.outputNombreText)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val salarioBaseText = inputSalarioBase.text.toString()

            if (salarioBaseText.isNotEmpty()) {
                try {
                    val salarioBase = salarioBaseText.toDouble()

                    val empleado = Empleado(nombre, salarioBase)
                    val salarioNeto = empleado.salarioNeto()

                    txtNombre.text = empleado.nombre
                    txtSalarioNeto.text = salarioNeto.toString()

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingrese un número válido para el salario base", Toast.LENGTH_SHORT).show()
                }
            } else {
                txtSalarioNeto.text = "Por favor ingrese un salario base válido"
            }
        }
    }
}
