package com.example.shopscout

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    // Firebase Authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Find the views from the XML layout
        val etName: EditText = findViewById(R.id.etName)
        val etPhoneNumber: EditText = findViewById(R.id.etPhoneNumber)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        // Set an onClickListener on the "REGISTER" button
        btnRegister.setOnClickListener {

            // Get user input values
            val nameInput = etName.text.toString()
            val phoneNumberInput = etPhoneNumber.text.toString()
            val emailInput = etEmail.text.toString()
            val passwordInput = etPassword.text.toString()

            // Validate the inputs
            if (nameInput.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.PHONE.matcher(phoneNumberInput).matches()) {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordInput.isEmpty() || passwordInput.length < 6) {
                Toast.makeText(this, "Please enter a password with at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Register the user using Firebase Authentication
            auth.createUserWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registration successful
                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()

                        // Navigate to the login page
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()  // Close the current activity
                    } else {
                        // Registration failed
                        Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
