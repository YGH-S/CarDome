package com.example.cardome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class MainActivity : AppCompatActivity(),OnClickListener {

    lateinit var btn1:Button
    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.main_btn1)
        btn2 = findViewById(R.id.main_btn2)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn1 -> {}
            btn2 -> {
                startActivity(Intent(this,LogoActivity::class.java))
            }
            else -> {

            }
        }
    }
}