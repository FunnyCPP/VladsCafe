package com.kiienkoromaniuk.vladscafe

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiienkoromaniuk.vladscafe.adapter.ShoppingCartAdapter
import com.kiienkoromaniuk.vladscafe.model.ShoppingCart

class ShopingCartActivity : AppCompatActivity() {

    lateinit var adapter: ShoppingCartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping_cart)
        val shopping_cart_recyclerView: RecyclerView= findViewById(R.id.shopping_cart_recyclerView)
        val total_price:TextView=findViewById(R.id.total_price)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material)
        upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.teal_200), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)


        adapter = ShoppingCartAdapter(this, ShoppingCart.getCart())
        adapter.notifyDataSetChanged()

        shopping_cart_recyclerView.adapter = adapter


        shopping_cart_recyclerView.layoutManager = LinearLayoutManager(this)


        var totalPrice = ShoppingCart.getCart()
            .fold(0.toDouble()) { acc, cartItem -> acc + cartItem.quantity.times(cartItem.product.price!!.toDouble()) }


        total_price.text = "$${totalPrice}"
    }
}