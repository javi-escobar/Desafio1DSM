package edu.udb.desafio1_1

class Student(
    private val name: String,
    private val grade1: Double,
    private val grade2: Double,
    private val grade3: Double,
    private val grade4: Double,
    private val grade5: Double
    ) {
    fun calculateAverage(): Double {
        return (grade1 * 0.15 + grade2 * 0.15 + grade3 * 0.20 + grade4 * 0.25 + grade5 * 0.25)
    }

    fun isPassed(): Boolean {
        return calculateAverage() >= 5.0
    }

    fun getName(): String {
        return name
    }
}