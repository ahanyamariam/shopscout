// HomeActivity.kt
package com.example.shopscout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cardFruits: CardView = findViewById(R.id.cardFruits)
        val cardVegetables: CardView = findViewById(R.id.cardVegetables)
        val cardMeat: CardView = findViewById(R.id.cardMeat)
        val cardSeafood: CardView = findViewById(R.id.cardSeafood)
        val cardBeverages: CardView = findViewById(R.id.cardBeverages)

        cardFruits.setOnClickListener {
            val intent = Intent(this, FruitsActivity::class.java)
            startActivity(intent)
        }

        cardVegetables.setOnClickListener {
            val intent = Intent(this, VegetablesActivity::class.java)
            startActivity(intent)
        }

        cardMeat.setOnClickListener {
            val intent = Intent(this, MeatActivity::class.java)
            startActivity(intent)
        }

        cardSeafood.setOnClickListener {
            val intent = Intent(this, SeafoodActivity::class.java)
            startActivity(intent)
        }

        cardBeverages.setOnClickListener {
            val intent = Intent(this, BeveragesActivity::class.java)
            startActivity(intent)
        }
    }
}
