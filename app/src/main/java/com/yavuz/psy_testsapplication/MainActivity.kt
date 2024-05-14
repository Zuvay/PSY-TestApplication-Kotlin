package com.yavuz.psy_testsapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editNameText: EditText
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
    fun goWho5(view:View){
        //Aktiviteler arası veri yollama için area verisini string hale getirdik.
        editNameText = findViewById(R.id.editNameText)
        val userInput: String = editNameText.text.toString()

        val intent = Intent(applicationContext,TestBir::class.java)
        //intent başlatılmadan önce veriyi gidilecek yere göneriyoruz.
        intent.putExtra("TextFromMainActivity", userInput)
        startActivity(intent)
    }

}