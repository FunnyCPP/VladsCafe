package com.kiienkoromaniuk.vladscafe.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitClient {

    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://raw.githubusercontent.com/FunnyCPP/FoodApi/main/"
        open fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }

}