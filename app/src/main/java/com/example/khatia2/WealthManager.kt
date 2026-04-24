package com.example.khatia2

class WealthManager {

    // K = (6 + 7) / 10 = 1.3 (დავუშვათ დაბადების რიცხვია 10)
    val kCoefficient = 1.3

    fun calculateSavings(income: Double, expense: Double): Double {
        if (income < expense) return 0.0
        return (income - expense) * kCoefficient
    }
}