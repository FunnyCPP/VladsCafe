package com.kiienkoromaniuk.vladscafe

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kiienkoromaniuk.vladscafe.model.Allmenu
import com.kiienkoromaniuk.vladscafe.model.CartItem
import com.kiienkoromaniuk.vladscafe.model.ShoppingCart
import io.paperdb.Paper


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
        Paper.init(this);
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
        var addToCart:Button=findViewById(R.id.add_to_cart)

        Glide.with(applicationContext).load(imageUrl).into(imageView)
        itemName.setText(name)
        itemPrice.setText("₹ $price")
        itemRating.setText(rating)
        ratingBar.setRating(rating!!.toFloat())
        addToCart.setOnClickListener {
             val allmenu: Allmenu=Allmenu()
            allmenu.note=""
            allmenu.deliveryCharges=""
            allmenu.rating=rating
            allmenu.deliveryTime=""
            allmenu.name=name
            allmenu.id="1"
            allmenu.imageUrl=imageUrl
            allmenu.price=price
            var product: CartItem= CartItem(quantity = 1, product = allmenu)
            ShoppingCart.addItem(product)
            val toast = Toast.makeText(applicationContext, "${allmenu.name} added to your cart ", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}