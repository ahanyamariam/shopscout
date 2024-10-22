package com.example.shopscout

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // References to the ImageViews
        val mainImageView = findViewById<ImageView>(R.id.mainProductImageView)
        val smallImage1 = findViewById<ImageView>(R.id.smallImage1)
        val smallImage2 = findViewById<ImageView>(R.id.smallImage2)
        val smallImage3 = findViewById<ImageView>(R.id.smallImage3)

        // References to the TextViews for product details
        val productNameTextView = findViewById<TextView>(R.id.productNameTextView)
        val productPriceTextView = findViewById<TextView>(R.id.productPriceTextView)
        val productDescriptionTextView = findViewById<TextView>(R.id.productDescriptionTextView)

        // Get the product details passed from the previous activity
        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getStringExtra("product_price")
        val productDescription = intent.getStringExtra("product_description")

        // Display the details if they are not null
        if (productName != null && productPrice != null && productDescription != null) {
            productNameTextView.text = productName
            productPriceTextView.text = productPrice
            productDescriptionTextView.text = productDescription
        } else {
            Toast.makeText(this, "Product details are missing", Toast.LENGTH_SHORT).show()
        }

        // Example image setup based on product name
        if (productName != null) {
            when (productName) {
                "Apple" -> {
                    setImages(
                        mainImageView, smallImage1, smallImage2, smallImage3,
                        R.drawable.apple, R.drawable.apples2, R.drawable.apples3, R.drawable.apples4
                    )
                }
                "Banana" -> {
                    setImages(
                        mainImageView, smallImage1, smallImage2, smallImage3,
                        R.drawable.banana, R.drawable.bananas2, R.drawable.banana3, R.drawable.bananas4
                    )
                }
                "Orange" -> {
                    setImages(
                        mainImageView, smallImage1, smallImage2, smallImage3,
                        R.drawable.oranges, R.drawable.oranges2, R.drawable.oranges3, R.drawable.oranges4
                    )
                }
                else -> {
                    setImages(
                        mainImageView, smallImage1, smallImage2, smallImage3,
                        R.drawable.default_image, R.drawable.default_image, R.drawable.default_image, R.drawable.default_image
                    )
                }
            }
        }

        // Swap functionality for the smaller images
        smallImage1.setOnClickListener {
            swapImages(mainImageView, smallImage1)
        }
        smallImage2.setOnClickListener {
            swapImages(mainImageView, smallImage2)
        }
        smallImage3.setOnClickListener {
            swapImages(mainImageView, smallImage3)
        }
    }

    // Function to set images for the main and smaller ImageViews
    private fun setImages(
        mainImageView: ImageView,
        smallImage1: ImageView,
        smallImage2: ImageView,
        smallImage3: ImageView,
        mainImageRes: Int,
        imageRes1: Int,
        imageRes2: Int,
        imageRes3: Int
    ) {
        mainImageView.setImageResource(mainImageRes)
        smallImage1.setImageResource(imageRes1)
        smallImage2.setImageResource(imageRes2)
        smallImage3.setImageResource(imageRes3)
    }

    // Function to swap images between the main image and the clicked smaller image
    private fun swapImages(mainImageView: ImageView, smallImageView: ImageView) {
        val tempImageDrawable = mainImageView.drawable
        mainImageView.setImageDrawable(smallImageView.drawable)
        smallImageView.setImageDrawable(tempImageDrawable)
    }
}
