package com.yavuz.psy_testsapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yavuz.psy_testsapplication.databinding.ActivityTestBirBinding
import com.yavuz.psy_testsapplication.databinding.ActivityTestBirResultBinding

class TestBirResult : AppCompatActivity() {
    private lateinit var binding: ActivityTestBirResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_bir_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityTestBirResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val getData = intent
        val totalScore = getData.getIntExtra("TestBirSonucu",0)
        val message = getData.getStringExtra("TestBirMesajı")
        binding.resultScore.text = "Test Skorunuz : $totalScore"
        binding.resultTextLong.text = message

        binding.toMainMenu.setOnClickListener {
            toMainMenu()
        }
    }

    private fun toMainMenu() {
        val toMain = Intent(applicationContext, MainActivity::class.java)
        startActivity(toMain)
        finish()
    }
}