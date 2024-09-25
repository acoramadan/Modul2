package com.example.modul2

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.modul2.model.Person

class MainActivity4 : AppCompatActivity() {

    private lateinit var tvNama : TextView
    private lateinit var tvStambuk : TextView
    private lateinit var tvKelas : TextView
    private lateinit var tvUmur : TextView
    private lateinit var tvObj : TextView

    companion object {
        private const val STATE_NAME = "state_nama"
        private const val STATE_STAMBUK = "state_stambuk"
        private const val STATE_KELAS = "state_kelas"
        private const val STATE_UMUR = "state_umur"
        
        private val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        tvNama = findViewById(R.id.nama1)
        tvStambuk = findViewById(R.id.stambuk1)
        tvKelas = findViewById(R.id.kelas1)
        tvUmur = findViewById(R.id.umur1)
        tvObj = findViewById(R.id.textobj)

//        tvNama.text = intent.getStringExtra(EXTRA_NAME)
//        tvStambuk.text = intent.getStringExtra(EXTRA_STAMBUK)
//        tvKelas.text = intent.getStringExtra(EXTRA_KELAS)
//        tvUmur.text = intent.getIntExtra(EXTRA_UMUR)

        val person = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON,Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null ) {
            tvNama.text = person.name
            tvStambuk.text = person.stambuk
            tvUmur.text = person.umur.toString()
            tvKelas.text = person.kelas

            val TEXT = "Halo\n" +
                    "${person.name}\n" +
                    "Stambuk :${person.stambuk}\n" +
                    "Umur :${person.umur}\n" +
                    "Kelas :${person.kelas}\n" +
                    "selamat datang."
            tvObj.text = TEXT
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}