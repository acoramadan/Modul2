package com.example.modul2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var tvName : TextView
    private lateinit var tvStambuk : TextView
    private lateinit var tvKelas : TextView

    companion object {
        private const val EXTRA_NAME = "extra_name"
        private const val EXTRA_STAMBUK = "extra_stambuk"
        private const val EXTRA_KELAS = "extra_kelas"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        tvName = findViewById(R.id.nama)
        tvStambuk = findViewById(R.id.stambuk)
        tvKelas = findViewById(R.id.kelas)

        val name = intent.getStringExtra(EXTRA_NAME)
        val stambuk = intent.getStringExtra(EXTRA_STAMBUK)
        val kelas = intent.getStringExtra(EXTRA_KELAS)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}