package com.example.modul2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity(), View.OnClickListener {
    private lateinit var rgAnswer : RadioGroup
    private lateinit var btnSubmit : Button

    companion object {
        const val EXTRA_ANSWER = "extra_answer"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        btnSubmit = findViewById(R.id.submit)
        rgAnswer = findViewById(R.id.groupjwbn)

        btnSubmit.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.submit -> {
                 var answer : Char = ' '
                when(rgAnswer.checkedRadioButtonId) {
                    R.id.answ1 -> answer = 'A'
                    R.id.answ2 -> answer = 'B'
                    R.id.answ3 -> answer = 'C'
                    R.id.answ4 -> answer = 'D'
                }
                val intent = Intent()
                intent.putExtra(EXTRA_ANSWER,answer)
                setResult(RESULT_CODE,intent)
                finish()
            }
        }
    }

}