package com.travelapp.tripsera

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splassh)  // ✅ XML file name sahi rakho (activity_splash.xml)

        // 1 second delay (1000 ms)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)  // ✅ Class name capitalized
            startActivity(intent)
            finish()
        }, 2000)
    }
}
