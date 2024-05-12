package com.yavuz.psy_testsapplication

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class testTwoActivity : AppCompatActivity() {
    private lateinit var buttonBos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_two)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Sayfada alttan mesaj gösterme
        Toast.makeText(this@testTwoActivity,"Test 2'ye hoşgeldiniz", Toast.LENGTH_LONG).show()
        buttonBos = findViewById(R.id.buttonBos)


    }
    fun mesajGoster(view : View){
        //Uyarı mesajını bu değişken üzerinden detaylandırıcaz
        val uyariMesaji = AlertDialog.Builder(this@testTwoActivity)
        uyariMesaji.setTitle("Sayfa Boş")
        uyariMesaji.setMessage("Bu sayfa boş ana sayfaya dönülsün mü?")

        uyariMesaji.setPositiveButton("Dönülsün",DialogInterface.OnClickListener { dialog, which ->
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
        })

        uyariMesaji.setNegativeButton("Dönülmesin"){dialog,which->
            Toast.makeText(this@testTwoActivity,"Sayfada kalmaya devam Ettiniz", Toast.LENGTH_LONG).show()
        }
        uyariMesaji.show()
    }
}