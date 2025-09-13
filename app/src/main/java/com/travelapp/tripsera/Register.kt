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

class Register : AppCompatActivity() {   // ✅ Capital letter se class name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ IDs match with XML
        val etName = findViewById<EditText>(R.id.name)
        val etEmail = findViewById<EditText>(R.id.Email)
        val etPassword = findViewById<EditText>(R.id.Password)
        val etOtp = findViewById<EditText>(R.id.otp)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBackToLogin = findViewById<Button>(R.id.btnBackToLogin)

        // Register button click
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val otp = etOtp.text.toString().trim()

            when {
                name.isEmpty() -> {
                    Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Please enter your Password", Toast.LENGTH_SHORT).show()
                }
                otp.isEmpty() -> {
                    Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Register, MainActivity::class.java) // Next page
                    startActivity(intent)
                }
            }
        }

        // Back to Login button click
        btnBackToLogin.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }
}
