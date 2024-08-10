package edu.udb.desafio1_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etGrade1: EditText
    private lateinit var etGrade2: EditText
    private lateinit var etGrade3: EditText
    private lateinit var etGrade4: EditText
    private lateinit var etGrade5: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etGrade1 = findViewById(R.id.etGrade1)
        etGrade2 = findViewById(R.id.etGrade2)
        etGrade3 = findViewById(R.id.etGrade3)
        etGrade4 = findViewById(R.id.etGrade4)
        etGrade5 = findViewById(R.id.etGrade5)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            calculateAverage()
        }
        }
    private fun calculateAverage() {
        val name = etName.text.toString().trim()
        val grade1Str = etGrade1.text.toString().trim()
        val grade2Str = etGrade2.text.toString().trim()
        val grade3Str = etGrade3.text.toString().trim()
        val grade4Str = etGrade4.text.toString().trim()
        val grade5Str = etGrade5.text.toString().trim()

        if (name.isEmpty() || grade1Str.isEmpty() || grade2Str.isEmpty() || grade3Str.isEmpty() || grade4Str.isEmpty() || grade5Str.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val grade1 = grade1Str.toDoubleOrNull()
        val grade2 = grade2Str.toDoubleOrNull()
        val grade3 = grade3Str.toDoubleOrNull()
        val grade4 = grade4Str.toDoubleOrNull()
        val grade5 = grade5Str.toDoubleOrNull()

        if (grade1 == null || grade2 == null || grade3 == null || grade4 == null || grade5 == null) {
            Toast.makeText(this, "Las notas deben ser números válidos", Toast.LENGTH_SHORT).show()
            return
        }

        if (!isValidGrade(grade1) || !isValidGrade(grade2) || !isValidGrade(grade3) || !isValidGrade(grade4) || !isValidGrade(grade5)) {
            Toast.makeText(this, "Las notas deben estar entre 0 y 10", Toast.LENGTH_SHORT).show()
            return
        }

        val student = Student(name, grade1, grade2, grade3, grade4, grade5)
        val average = student.calculateAverage()
        val passed = student.isPassed()

        val result = "Estudiante: ${student.getName()}\nPromedio: $average\n${if (passed) "Aprobado" else "Reprobado"}"
        tvResult.text = result
    }

    private fun isValidGrade(grade: Double): Boolean {
        return grade in 0.0..10.0
    }
}