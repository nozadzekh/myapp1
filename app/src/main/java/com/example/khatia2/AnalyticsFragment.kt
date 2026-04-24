package com.example.khatia2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    private val manager = WealthManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultText = view.findViewById<TextView>(R.id.kn_ze_tv_result)

        parentFragmentManager.setFragmentResultListener(
            "finance_data",
            viewLifecycleOwner
        ) { _, bundle ->
            val income = bundle.getDouble("income")
            val expense = bundle.getDouble("expense")

            val result = manager.calculateSavings(income, expense)
            resultText.text = "Final Savings: ${String.format("%.2f", result)}"
        }
    }
}