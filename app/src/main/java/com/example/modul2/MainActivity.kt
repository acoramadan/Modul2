package com.example.modul2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var pndh: Button
    private lateinit var pndhData : Button

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        pndh = findViewById(R.id.btnpindahactivity)
        pndhData = findViewById(R.id.btndata)
        pndh.setOnClickListener(this)
        pndhData.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnpindahactivity -> {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.btndata -> {
                val intent = Intent(this@MainActivity, MainActivity3::class.java)
                startActivity(intent)
            }
        }
    }
}