package com.kiienkoromaniuk.vladscafe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiienkoromaniuk.vladscafe.adapter.AllMenuAdapter
import com.kiienkoromaniuk.vladscafe.adapter.PopularAdapter
import com.kiienkoromaniuk.vladscafe.adapter.RecommendedAdapter
import com.kiienkoromaniuk.vladscafe.model.Allmenu
import com.kiienkoromaniuk.vladscafe.model.FoodData
import com.kiienkoromaniuk.vladscafe.model.Popular
import com.kiienkoromaniuk.vladscafe.model.Recommended
import com.kiienkoromaniuk.vladscafe.retrofit.ApiInterface
import com.kiienkoromaniuk.vladscafe.retrofit.RetrofitClient
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiInterface: ApiInterface? = null

    var popularRecyclerView: RecyclerView? = null
    var recommendedRecyclerView:RecyclerView? = null
    var allMenuRecyclerView:RecyclerView? = null

    var popularAdapter: PopularAdapter? = null
    var recommendedAdapter: RecommendedAdapter? = null
    var allMenuAdapter: AllMenuAdapter? = null
    private var products = listOf<Allmenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Paper.init(this);
        apiInterface = RetrofitClient.getRetrofitInstance()!!.create<ApiInterface>(ApiInterface::class.java)
        val showcart:ImageView=findViewById(R.id.showCart)
        val call: Call<MutableList<FoodData?>?>? = apiInterface!!.getAllData()
        call!!.enqueue(object : Callback<MutableList<FoodData?>?> {
            override fun onResponse(
                call: Call<MutableList<FoodData?>?>?,
                response: Response<MutableList<FoodData?>?>
            ) {
                val foodDataList: MutableList<FoodData?>? = response.body()

                getPopularData(foodDataList!![0]!!.popular)
                getRecommendedData(foodDataList[0]!!.recommended!!)
                getAllMenu(foodDataList[0]!!.allmenu!!)
                // lets run it.
                // we have fetched data from server.
                // now we have to show data in app using recycler view
                // lets make recycler view adapter
                // we have setup and bind popular section
                // in a same way we add recommended and all menu items
                // we add two adapter class for allmenu and recommended items.
                // so lets do it fast.
            }

            override fun onFailure(call: Call<MutableList<FoodData?>?>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Server is not responding.", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        showcart.setOnClickListener{
            startActivity(Intent(this, ShopingCartActivity::class.java))
        }
    }
    private fun getPopularData(popularList: List<Popular>?) {
       var popularRecyclerView = findViewById<RecyclerView>(R.id.popular_recycler)
        popularAdapter = PopularAdapter(this, popularList)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popularRecyclerView.layoutManager=layoutManager
        popularRecyclerView.adapter=popularAdapter
    }

    private fun getRecommendedData(recommendedList: List<Recommended>) {
        var recommendedRecyclerView = findViewById<RecyclerView>(R.id.recommended_recycler)
        recommendedAdapter = RecommendedAdapter(this, recommendedList)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recommendedRecyclerView.setLayoutManager(layoutManager)
        recommendedRecyclerView.setAdapter(recommendedAdapter)
    }

    private fun getAllMenu(allmenuList: List<Allmenu>) {
        var allMenuRecyclerView = findViewById<RecyclerView>(R.id.all_menu_recycler)
        allMenuAdapter = AllMenuAdapter(this, allmenuList)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        allMenuRecyclerView.setLayoutManager(layoutManager)
        allMenuRecyclerView.setAdapter(allMenuAdapter)
        allMenuAdapter!!.notifyDataSetChanged()
    }
}


