package com.kiienkoromaniuk.vladscafe.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Popular {
    @SerializedName("name")
    @Expose
     val name: String? = null

    @SerializedName("imageUrl")
    @Expose
     val imageUrl: String? = null

    @SerializedName("rating")
    @Expose
     val rating: String? = null

    @SerializedName("deliveryTime")
    @Expose
     val deliveryTime: String? = null

    @SerializedName("deliveryCharges")
    @Expose
     val deliveryCharges: String? = null

    @SerializedName("price")
    @Expose
     val price: String? = null

    @SerializedName("note")
    @Expose
     val note: String? = null

}