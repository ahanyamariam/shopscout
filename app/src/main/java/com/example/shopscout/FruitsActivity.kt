// FruitsActivity.kt
package com.example.shopscout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FruitsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        // Ensure these IDs match those in your XML layout file
        val cardApple: CardView = findViewById(R.id.cardProduct1)
        val cardBanana: CardView = findViewById(R.id.cardProduct2)
        val cardOrange: CardView = findViewById(R.id.cardProduct3)
        val cardPomegranate: CardView = findViewById(R.id.cardProduct4)

        // Set up the click listener for the Apple card
        cardApple.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product_name", "Apple")
            intent.putExtra("product_price", "₹100")
            intent.putExtra("product_description", "Fresh and juicy apples.")
            startActivity(intent)
        }

        // Set up the click listener for the Banana card
        cardBanana.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product_name", "Banana")
            intent.putExtra("product_price", "₹50")
            intent.putExtra("product_description", "Sweet and ripe bananas, perfect for snacking.")
            startActivity(intent)
        }

        // Set up the click listener for the Orange card
        cardOrange.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product_name", "Orange")
            intent.putExtra("product_price", "₹80")
            intent.putExtra("product_description", "Juicy oranges full of vitamin C.")
            startActivity(intent)
        }

        // Set up the click listener for the Pomegranate card
        cardPomegranate.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product_name", "Pomegranate")
            intent.putExtra("product_price", "₹150")
            intent.putExtra("product_description", "Fresh pomegranates with rich flavor and nutrients.")
            startActivity(intent)
        }
    }
}
