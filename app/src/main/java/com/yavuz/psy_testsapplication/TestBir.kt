package com.yavuz.psy_testsapplication

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.iterator
import com.yavuz.psy_testsapplication.databinding.ActivityTestBirBinding

class TestBir : AppCompatActivity() {

    private lateinit var binding: ActivityTestBirBinding // Componentlere direkt bu yöntemle erişebiliyoruz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBirBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Veriyi almak için onCreate fonksiyonunun içindeyiz
        val getData = intent
        val alinanVeri = getData.getStringExtra("TextFromMainActivity")
        binding.welcomeTextView.text = "Selam $alinanVeri"


        binding.submitButton.setOnClickListener {
            val (totalScore, message) = calculate()
            if (totalScore != -1) {
                val intent = Intent(applicationContext, TestBirResult::class.java)
                intent.putExtra("TestBirSonucu", totalScore)
                intent.putExtra("TestBirMesajı", message)
                startActivity(intent)
            }
        }
    }

    private fun calculate(): Pair<Int, String> {
        var totalScore = 0 // Reset total score for each calculation
        var message = ""

        if (!isAllQuestionsAnswered()) {
            Toast.makeText(this, "Tüm Sorular Cevaplanmalıdır", Toast.LENGTH_LONG).show()
            return Pair(-1, message)
        } else {
            val selectedRadioButton1 = findViewById<RadioButton>(binding.radioGroup1.checkedRadioButtonId)
            val selectedAnswer1 = selectedRadioButton1?.tag?.toString()?.toIntOrNull()
            if (selectedAnswer1 != null) totalScore += selectedAnswer1

            val selectedRadioButton2 = findViewById<RadioButton>(binding.radioGroup2.checkedRadioButtonId)
            val selectedAnswer2 = selectedRadioButton2?.tag?.toString()?.toIntOrNull()
            if (selectedAnswer2 != null) totalScore += selectedAnswer2

            val selectedRadioButton3 = findViewById<RadioButton>(binding.radioGroup3.checkedRadioButtonId)
            val selectedAnswer3 = selectedRadioButton3?.tag?.toString()?.toIntOrNull()
            if (selectedAnswer3 != null) totalScore += selectedAnswer3

            val selectedRadioButton4 = findViewById<RadioButton>(binding.radioGroup4.checkedRadioButtonId)
            val selectedAnswer4 = selectedRadioButton4?.tag?.toString()?.toIntOrNull()
            if (selectedAnswer4 != null) totalScore += selectedAnswer4

            val selectedRadioButton5 = findViewById<RadioButton>(binding.radioGroup5.checkedRadioButtonId)
            val selectedAnswer5 = selectedRadioButton5?.tag?.toString()?.toIntOrNull()
            if (selectedAnswer5 != null) totalScore += selectedAnswer5

            message = when (totalScore) {
                in 0..5 -> TestBirMessages.MESSAGE_FOR_0_5.text
                in 6..10 -> TestBirMessages.MESSAGE_FOR_6_10.text
                in 11..16 -> TestBirMessages.MESSAGE_FOR_11_16.text
                else -> "Bilinmeyen Skor"
            }
            return Pair(totalScore, message)
        }
    }

    private fun isAllQuestionsAnswered():Boolean{
        val radioGroupList = listOf<RadioGroup>(
            binding.radioGroup1,
            binding.radioGroup2,
            binding.radioGroup3,
            binding.radioGroup4,
            binding.radioGroup5,
        )

        for (radioElement in radioGroupList){
            if (radioElement.checkedRadioButtonId == -1){
                return false
            }
        }
        return true
    }
}