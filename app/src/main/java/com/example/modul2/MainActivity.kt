package com.example.modul2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.modul2.model.Person

private data class Mahasiswa(val nama: String, val stambuk: String, val kelas: String)

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var pndh: Button
    private lateinit var pndhData: Button
    private lateinit var pndhObj: Button
    private lateinit var kontak: Button
    private lateinit var camera: Button
    private lateinit var proses: Button
    private lateinit var tvHasil: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MainActivity5.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getCharExtra(MainActivity5.EXTRA_ANSWER, ' ')
            tvHasil.text = "HASIL : $selectedValue"
        }
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
        private const val STATE_RESULT = "state_result"
        private const val EXTRA_NAMA = "extra_name"
        private const val EXTRA_STAMBUK = "extra_stambuk"
        private const val EXTRA_KELAS = "extra_kelas"
        private val MAHASISWA = Mahasiswa("Ahmad Mufli Ramadhan", "13020220227", "A6")
        private val PERSON =
            Person(
                "Ahmad gacor",
                "1302022",
                "A6",
                30
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        pndh = findViewById(R.id.btnpindahactivity)
        pndhData = findViewById(R.id.btndata)
        pndhObj = findViewById(R.id.btngacor)
        kontak = findViewById(R.id.kontak)
        camera = findViewById(R.id.camera)
        proses = findViewById(R.id.btnproses)
        tvHasil = findViewById(R.id.hasil)

        pndh.setOnClickListener(this)
        pndhData.setOnClickListener(this)
        pndhObj.setOnClickListener(this)
        kontak.setOnClickListener(this)
        camera.setOnClickListener(this)
        proses.setOnClickListener(this)

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
                intent.putExtra(EXTRA_NAMA, MAHASISWA.nama)
                intent.putExtra(EXTRA_STAMBUK, MAHASISWA.stambuk)
                intent.putExtra(EXTRA_KELAS, MAHASISWA.kelas)
                startActivity(intent)
            }

            R.id.btngacor -> {
                val intent = Intent(this@MainActivity, MainActivity4::class.java)
                intent.putExtra(MainActivity.EXTRA_PERSON, PERSON)
                startActivity(intent)
            }

            R.id.kontak -> {
                val nomor = "089698100654"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomor"))
                startActivity(intent)
            }

            R.id.camera -> {
                val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
                startActivity(intent)
            }

            R.id.btnproses -> {
                val intent = Intent(this@MainActivity, MainActivity5::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}