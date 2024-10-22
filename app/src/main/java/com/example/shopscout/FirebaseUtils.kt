// FirebaseUtils.kt
package com.example.shopscout

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseUtils {
    private val firestore = FirebaseFirestore.getInstance()

    // Function to add data to Firebase Firestore
    fun addDataToFirebase(name: String, description: String, context: Context) {
        // Create a HashMap to store data
        val data = hashMapOf(
            "name" to name,
            "description" to description
        )

        // Add data to the "fruits" collection in Firestore
        firestore.collection("fruits")
            .add(data)
            .addOnSuccessListener {
                // Show a success toast message
                Toast.makeText(context, "Data added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                // Show a failure toast message with the error
                Toast.makeText(context, "Failed to add data: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
