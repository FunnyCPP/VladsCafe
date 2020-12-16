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
import com.kiienkoromaniuk.vladscafe.model.Recommended


class RecommendedAdapter(context: Context, recommendedList: List<Recommended>) :
    RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder>() {
    private val context: Context
    private val recommendedList: List<Recommended>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.recommendedName.text = recommendedList[position].name
        holder.recommendedRating.text = recommendedList[position].rating
        holder.recommendedCharges.text = recommendedList[position].deliveryCharges
        holder.recommendedDeliveryTime.text = recommendedList[position].deliveryTime
        holder.recommendedPrice.text = "₹ " + recommendedList[position].price
        Glide.with(context).load(recommendedList[position].imageUrl).into(holder.recommendedImage)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val i = Intent(context, FoodDetails::class.java)
                i.putExtra("name", recommendedList[position].name)
                i.putExtra("price", recommendedList[position].price)
                i.putExtra("rating", recommendedList[position].rating)
                i.putExtra("image", recommendedList[position].imageUrl)
                context.startActivity(i)
            }
        })
    }

    override fun getItemCount(): Int {
        return recommendedList.size
    }

    class RecommendedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recommendedImage: ImageView
        var recommendedName: TextView
        var recommendedRating: TextView
        var recommendedDeliveryTime: TextView
        var recommendedCharges: TextView
        var recommendedPrice: TextView

        init {
            recommendedImage = itemView.findViewById(R.id.recommended_image)
            recommendedName = itemView.findViewById(R.id.recommended_name)
            recommendedRating = itemView.findViewById(R.id.recommended_rating)
            recommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time)
            recommendedCharges = itemView.findViewById(R.id.delivery_type)
            recommendedCharges = itemView.findViewById(R.id.delivery_type)
            recommendedPrice = itemView.findViewById(R.id.recommended_price)
        }
    }

    init {
        this.context = context
        this.recommendedList = recommendedList
    }
}
