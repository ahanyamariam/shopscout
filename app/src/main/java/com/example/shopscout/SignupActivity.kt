package com.example.shopscout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Find the views from the XML layout
        val etName: EditText = findViewById(R.id.etName)
        val etPhoneNumber: EditText = findViewById(R.id.etPhoneNumber)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword) // Password Field
        val btnRegister: Button = findViewById(R.id.btnRegister)

        // SharedPreferences to store user details locally
        val sharedPreferences: SharedPreferences = getSharedPreferences("userPrefs", Context.MODE_PRIVATE)

        // Retrieve user data from SharedPreferences (if available)
        val name = sharedPreferences.getString("userName", "")
        val phone = sharedPreferences.getString("userPhone", "")
        val email = sharedPreferences.getString("userEmail", "")
        val password = sharedPreferences.getString("userPassword", "") // Password

        // Populate the EditText fields if data exists in SharedPreferences
        etName.setText(name)
        etPhoneNumber.setText(phone)
        etEmail.setText(email)
        etPassword.setText(password)

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

            // If inputs are valid, save user data using SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("userName", nameInput)
            editor.putString("userPhone", phoneNumberInput)
            editor.putString("userEmail", emailInput)
            editor.putString("userPassword", passwordInput) // Save password
            editor.apply()

            // Notify user of successful registration
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()

            // Navigate to the login page after successful registration
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Close the current activity so user can't navigate back
        }
    }
}
