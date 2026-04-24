package com.example.khatia2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val incomeEt = view.findViewById<EditText>(R.id.kn_ze_et_income)
        val expenseEt = view.findViewById<EditText>(R.id.kn_ze_et_expense)
        val saveBtn = view.findViewById<Button>(R.id.kn_ze_btn_save)

        saveBtn.setOnClickListener {
            val incomeStr = incomeEt.text.toString()
            val expenseStr = expenseEt.text.toString()

            var isValid = true

            if (incomeStr.isEmpty()) {
                incomeEt.error = "Please enter income"
                isValid = false
            }

            if (expenseStr.isEmpty()) {
                expenseEt.error = "Please enter expenses"
                isValid = false
            }

            if (!isValid) return@setOnClickListener

            val income = incomeStr.toDoubleOrNull() ?: 0.0
            val expense = expenseStr.toDoubleOrNull() ?: 0.0

            val bundle = Bundle()
            bundle.putDouble("income", income)
            bundle.putDouble("expense", expense)

            parentFragmentManager.setFragmentResult("finance_data", bundle)
            
            // კლავიატურის დამალვა
            val imm = context?.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? android.view.inputmethod.InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)

            // გადასვლა Analytics ფრაგმენტზე
            (activity as? MainActivity)?.findViewById<ViewPager2>(R.id.kn_ze_viewPager)?.currentItem = 1
        }
    }
}