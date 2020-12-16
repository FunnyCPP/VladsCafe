package com.kiienkoromaniuk.vladscafe

import android.R.attr.rating
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


class FoodDetails : AppCompatActivity() {

    var imageView: ImageView? = null
    var itemName: TextView? = null
    var itemPrice:TextView? = null
    var itemRating:TextView? = null
    var ratingBar: RatingBar? = null

    var name: String? = null
    var price: String? = null
    var rating: String? = null
    var imageUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val intent = intent

        name = intent.getStringExtra("name")
        price = intent.getStringExtra("price")
        rating = intent.getStringExtra("rating")
        imageUrl = intent.getStringExtra("image")

        var imageView = findViewById<ImageView>(R.id.imageView5)
        var itemName = findViewById<TextView>(R.id.name)
        var itemPrice = findViewById<TextView>(R.id.price)
        var itemRating = findViewById<TextView>(R.id.rating)
        var ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        Glide.with(applicationContext).load(imageUrl).into(imageView)
        itemName.setText(name)
        itemPrice.setText("₹ $price")
        itemRating.setText(rating)
        ratingBar.setRating(rating!!.toFloat())
    }
}