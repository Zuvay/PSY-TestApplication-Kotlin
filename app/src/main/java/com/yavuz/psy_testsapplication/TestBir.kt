package com.yavuz.psy_testsapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yavuz.psy_testsapplication.databinding.ActivityTestBirBinding

class TestBir : AppCompatActivity() {

    private lateinit var binding: ActivityTestBirBinding // Bağlama sınıfından bir değişken oluşturuluyor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBirBinding.inflate(layoutInflater) // Bağlama sınıfı şişiriliyor
        val view = binding.root
        setContentView(view)

        // Veriyi almak için onCreate fonksiyonunun içindeyiz
        val getData = intent
        val alinanVeri = getData.getStringExtra("TextFromMainActivity")
        binding.welcomeTextView.text = "Selam $alinanVeri" // welcomeTextView'e erişiliyor ve metin atanıyor
    }
}