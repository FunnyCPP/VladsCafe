package com.kiienkoromaniuk.vladscafe.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiienkoromaniuk.vladscafe.FoodDetails
import com.kiienkoromaniuk.vladscafe.R
import com.kiienkoromaniuk.vladscafe.model.Allmenu


class AllMenuAdapter(context: Context, allmenuList: List<Allmenu>) :
    RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder>() {
    var context: Context
    var allmenuList: List<Allmenu>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMenuViewHolder {
        val view: View =
                    LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false)
        return AllMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllMenuViewHolder, position: Int) {
        holder.allMenuName.setText(allmenuList[position].name)
        holder.allMenuPrice.text = "₹ " + allmenuList[position].price
        holder.allMenuTime.setText(allmenuList[position].deliveryTime)
        holder.allMenuRating.setText(allmenuList[position].rating)
        holder.allMenuCharges.setText(allmenuList[position].deliveryCharges)
        holder.allMenuNote.setText(allmenuList[position].note)
        Glide.with(context).load(allmenuList[position].imageUrl).into(holder.allMenuImage)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val i = Intent(context, FoodDetails::class.java)
                i.putExtra("name", allmenuList[position].name)
                i.putExtra("price", allmenuList[position].price)
                i.putExtra("rating", allmenuList[position].rating)
                i.putExtra("image", allmenuList[position].imageUrl)
                context.startActivity(i)
            }
        })
    }

    override fun getItemCount(): Int {
        return allmenuList.size
    }

    class AllMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var allMenuName: TextView
        var allMenuNote: TextView
        var allMenuRating: TextView
        var allMenuTime: TextView
        var allMenuCharges: TextView
        var allMenuPrice: TextView
        var allMenuImage: ImageView

        init {
            allMenuName = itemView.findViewById(R.id.all_menu_name)
            allMenuNote = itemView.findViewById(R.id.all_menu_note)
            allMenuCharges = itemView.findViewById(R.id.all_menu_delivery_charge)
            allMenuRating = itemView.findViewById(R.id.all_menu_rating)
            allMenuTime = itemView.findViewById(R.id.all_menu_deliverytime)
            allMenuPrice = itemView.findViewById(R.id.all_menu_price)
            allMenuImage = itemView.findViewById(R.id.all_menu_image)
        }
    }

    init {
        this.context = context
        this.allmenuList = allmenuList
    }
}
