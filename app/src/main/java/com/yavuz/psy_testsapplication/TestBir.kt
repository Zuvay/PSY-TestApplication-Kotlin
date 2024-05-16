package com.yavuz.psy_testsapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yavuz.psy_testsapplication.databinding.ActivityTestBirBinding

class TestBir : AppCompatActivity() {

    private lateinit var binding: ActivityTestBirBinding // Componentlere direkt bu yöntemle erişebiliyoruz
    private var totalScore = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBirBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Veriyi almak için onCreate fonksiyonunun içindeyiz
        val getData = intent
        val alinanVeri = getData.getStringExtra("TextFromMainActivity")
        binding.welcomeTextView.text = "Selam $alinanVeri"

        gonder()
        println(totalScore)

    }

    fun gonder() {
        binding.submitButton.setOnClickListener{
            val selectedAnswer1 = binding.radioGroup1.tag.toString().toIntOrNull()
            if (selectedAnswer1!=null){
                totalScore+=selectedAnswer1
            }else{
                totalScore+=0
            }

            val selectedAnswer2 = binding.radioGroup2.tag.toString().toIntOrNull()
            if (selectedAnswer2!=null){
                totalScore+=selectedAnswer2
            }else{
                totalScore+=0
            }

            val selectedAnswer3 = binding.radioGroup3.tag.toString().toIntOrNull()
            if (selectedAnswer3!=null){
                totalScore+=selectedAnswer3
            }else{
                totalScore+=0
            }

            val selectedAnswer4 = binding.radioGroup4.tag.toString().toIntOrNull()
            if (selectedAnswer4!=null){
                totalScore+=selectedAnswer4
            }else{
                totalScore+=0
            }

            val selectedAnswer5 = binding.radioGroup5.tag.toString().toIntOrNull()
            if (selectedAnswer5!=null){
                totalScore+=selectedAnswer5
            }else{
                totalScore+=0
            }

            //Toast.makeText(this, "Toplam Puan: $totalScore", Toast.LENGTH_LONG).show()

        }
    }
}