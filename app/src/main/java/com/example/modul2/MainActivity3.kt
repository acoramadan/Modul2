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
        private const val STATE_NAME = "state_name"
        private const val STATE_STAMBUK = "state_stambuk"
        private const val STATE_KELAS = "state_kelas"
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

        tvName.text = name
        tvStambuk.text = stambuk
        tvKelas.text = kelas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if(savedInstanceState != null) {
            val NAMA = savedInstanceState.getString(STATE_NAME)
            val STAMBUK = savedInstanceState.getString(STATE_STAMBUK)
            val KELAS = savedInstanceState.getString(STATE_KELAS)
            tvName.text = NAMA
            tvStambuk.text = STAMBUK
            tvKelas.text = KELAS
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_NAME,tvName.text.toString())
        outState.putString(STATE_STAMBUK,tvStambuk.text.toString())
        outState.putString(STATE_KELAS,tvKelas.text.toString())
    }
}