package com.example.tipofthemornin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipofthemornin.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculatings.setOnClickListener(calculatetip())
    }

    fun calculatetip()
    {
        val stringInTextField = binding.BobucksGiven.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedpercent = binding.tipping.checkedRadioButtonId

        val tipPercent = when(selectedpercent)
        {
            R.id.Twenny -> 0.20
            R.id.eighteen -> 0.18
            else -> 0.15
        }

        val tip = tipPercent * cost
        val roundup = binding.Switch.isChecked
        tip = kotlin.math.ceil(tip)
        NumberFormat.getCurrencyInstance()

        val formattedtip = NumberFormat.getCurrencyInstance().format(tip)
        binding.results.text = getString(R.string.Results, formattedtip)

    }
}