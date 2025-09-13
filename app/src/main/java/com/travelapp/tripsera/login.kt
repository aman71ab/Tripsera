package com.travelapp.tripsera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ Correct IDs (ye aapke XML ke hisaab se hone chahiye)
        val etMobile = findViewById<EditText>(R.id.no)
        val etOtp = findViewById<EditText>(R.id.otp)
        val btnLogin = findViewById<Button>(R.id.login)       // LOGIN button
        val btnRegister = findViewById<Button>(R.id.register) // REGISTER button

        // LOGIN button click
        btnLogin.setOnClickListener {
            val mobile = etMobile.text.toString().trim()
            val otp = etOtp.text.toString().trim()

            when {
                mobile.isEmpty() -> {
                    Toast.makeText(this, "Please enter Mobile Number", Toast.LENGTH_SHORT).show()
                }
                otp.isEmpty() -> {
                    Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        // REGISTER button click ✅
        btnRegister.setOnClickListener {
            val intent = Intent(this@Login, register::class.java)
            startActivity(intent)
        }
    }
}
