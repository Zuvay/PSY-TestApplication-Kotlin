package com.yavuz.psy_testsapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var testOneButton: Button
    private lateinit var testTwoButton: Button
    private lateinit var testThreeButton: Button
    private lateinit var editNameText: EditText
    private lateinit var welcomeLabel : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun goTestOne(view:View){
        //Aktiviteler arası veri yollama için area verisini string hale getirdik
        editNameText = findViewById(R.id.editNameText)
        val userInput: String = editNameText.text.toString()

        val intent = Intent(applicationContext,testOneActivity::class.java)
        //intent başlatılmadan önce veriyi gidilecek yere göneriyoruz.
        intent.putExtra("TextFromMainActivity", userInput)
        startActivity(intent)
    }
    fun goTestTwo(view:View){
        val intent = Intent(applicationContext,testTwoActivity::class.java)
        startActivity(intent)
    }
    fun goTestThree(view:View){
        val intent = Intent(applicationContext,testThreeActivity::class.java)
        startActivity(intent)
    }


}