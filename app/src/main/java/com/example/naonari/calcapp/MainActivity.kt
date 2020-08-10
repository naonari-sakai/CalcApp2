package com.example.naonari.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
    }
    var Calculation:Double = 0.0

    override fun onClick(v: View?) {
        if (editTextNumber.text != null && editTextNumber2.text != null) {
            var firstNumber = editTextNumber.text.toString().toDouble()
            var SecondNumber = editTextNumber.text.toString().toDouble()

            if (v != null) {
                when (v.id) {
                    R.id.buttonPlus -> Calculation = firstNumber + SecondNumber
                    R.id.buttonMinus -> Calculation = firstNumber - SecondNumber
                    R.id.buttonMultiply ->Calculation = firstNumber * SecondNumber
                    R.id.buttonDivision -> Calculation = firstNumber / SecondNumber
                }
            }
            move(Calculation)
                    }
    }

    private fun move(calculation:Double){
        val intent = Intent(this,result::class.java)
        intent.putExtra("result",calculation)
        startActivity(intent)
    }


}