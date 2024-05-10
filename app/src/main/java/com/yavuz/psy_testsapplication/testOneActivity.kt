package com.yavuz.psy_testsapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class testOneActivity : AppCompatActivity() {
    private lateinit var welcomeTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //Veriyi almak için onCreate fonksiyonunun içindeyiz
        val getData = intent
        val alinanVeri = getData.getStringExtra("TextFromMainActivity")
        welcomeTextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text= "Selam $alinanVeri"
    }
}