package com.kiienkoromaniuk.vladscafe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiienkoromaniuk.vladscafe.R
import com.kiienkoromaniuk.vladscafe.model.CartItem
import com.squareup.picasso.Picasso

class ShoppingCartAdapter(var context: Context, var cartItems: List<CartItem>) :
    RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ShoppingCartAdapter.ViewHolder {

        val layout = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(viewHolder: ShoppingCartAdapter.ViewHolder, position: Int) {

        viewHolder.bindItem(cartItems[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(cartItem: CartItem) {

               var allMenuName: TextView = itemView.findViewById(R.id.all_menu_name)
               var allMenuNote: TextView = itemView.findViewById(R.id.all_menu_note)
               var allMenuCharges: TextView = itemView.findViewById(R.id.all_menu_delivery_charge)
               var allMenuRating: TextView = itemView.findViewById(R.id.all_menu_rating)
               var allMenuTime : TextView= itemView.findViewById(R.id.all_menu_deliverytime)
                var allMenuPrice : TextView= itemView.findViewById(R.id.all_menu_price)


            val imageView: ImageView=itemView.findViewById(R.id.all_menu_image)
            Picasso.get().load(cartItem.product.imageUrl).fit().into(imageView)


            allMenuName.text = cartItem.product.name

            allMenuPrice.text = "$${cartItem.product.price}"

            allMenuRating.text = cartItem.quantity.toString()

        }


    }


}