package com.kiienkoromaniuk.vladscafe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FoodData {
    @SerializedName("popular")
    @Expose
    var popular: List<Popular>? = null

    @SerializedName("recommended")
    @Expose
    var recommended: List<Recommended>? = null

    @SerializedName("allmenu")
    @Expose
    var allmenu: List<Allmenu>? = null

}

