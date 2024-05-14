import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yavuz.psy_testsapplication.databinding.ActivityTestOneBinding

class testOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestOneBinding // Bağlama sınıfından bir değişken oluşturuluyor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestOneBinding.inflate(layoutInflater) // Bağlama sınıfı şişiriliyor
        val view = binding.root
        setContentView(view)

        // Veriyi almak için onCreate fonksiyonunun içindeyiz
        val getData = intent
        val alinanVeri = getData.getStringExtra("TextFromMainActivity")
        binding.welcomeTextView.text = "Selam $alinanVeri" // welcomeTextView'e erişiliyor ve metin atanıyor
    }
}
