package com.travelapp.tripsera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Register jane wala button
        val btnGoRegister = findViewById<Button>(R.id.asdff)
        btnGoRegister.setOnClickListener {
            val intent = Intent(this@login, register::class.java)
            startActivity(intent)
        }

        // Agar register ke baad wapas aaye ho to yaha se MainActivity jao
        val btnLoginNext = findViewById<Button>(R.id.asdfff)
        btnLoginNext.setOnClickListener {
            val intent = Intent(this@login, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
