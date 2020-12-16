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
import com.kiienkoromaniuk.vladscafe.model.Popular


class PopularAdapter(context: Context, popularList: List<Popular>?) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    private val context: Context
    private val popularList: List<Popular>?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false)
        // here we need to create a layout for recyclerview cell items.
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.popularName.setText(popularList!![position].name)

        // for image we add Glide library dependency for image fetching from server
        Glide.with(context).load(popularList[position].imageUrl).into(holder.popularImage)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val i = Intent(context, FoodDetails::class.java)
                i.putExtra("name", popularList[position].name)
                i.putExtra("price", popularList[position].price)
                i.putExtra("rating", popularList[position].rating)
                i.putExtra("image", popularList[position].imageUrl)
                context.startActivity(i)
            }
        })
    }

    override fun getItemCount(): Int {
        return popularList!!.size
    }

    class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var popularImage: ImageView
        var popularName: TextView

        init {
            popularName = itemView.findViewById(R.id.all_menu_name)
            popularImage = itemView.findViewById(R.id.all_menu_image)
        }
    }

    init {
        this.context = context
        this.popularList = popularList
    }
}
