// FruitsAdapter.kt
package com.example.shopscout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopscout.Fruit
import com.example.shopscout.R // Adjust this to your actual package path



class FruitsAdapter(private val fruitsList: List<Fruit>) : RecyclerView.Adapter<FruitsAdapter.FruitViewHolder>() {

    inner class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitName: TextView = itemView.findViewById(R.id.productName1)
        val fruitPrice: TextView = itemView.findViewById(R.id.productPrice1)
        val fruitDescription: TextView = itemView.findViewById(R.id.fruitDescription)
        val fruitImage: ImageView = itemView.findViewById(R.id.productImage1)

        fun bind(fruit: Fruit) {
            fruitName.text = fruit.name
            fruitPrice.text = "₹${fruit.price}"
            fruitDescription.text = fruit.description
            // Load the image using Glide
            Glide.with(itemView.context).load(fruit.imageUrl).into(fruitImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}
