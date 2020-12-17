package com.kiienkoromaniuk.vladscafe.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("products")
    var products: List<Allmenu> = listOf()
)