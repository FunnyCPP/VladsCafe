package com.kiienkoromaniuk.vladscafe.retrofit

import com.kiienkoromaniuk.vladscafe.model.FoodData
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("FoodAppJSON.json")
    open fun getAllData(): Call<MutableList<FoodData?>?>?

}