package com.example.shopscout

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImageView: ImageView = findViewById(R.id.logoImageView)

        // Create fade-in animation for the logo
        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 2000 // 2 seconds for fade-in

        logoImageView.startAnimation(fadeIn)

        // After the animation finishes, navigate to the login page
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // Total duration for splash screen (3 seconds)
    }
}
