package com.rp.wmytestapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rp.wmytestapplication.adapter.CountryListAdapter
import com.rp.wmytestapplication.api.RestClient
import com.rp.wmytestapplication.models.CountryListData
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvCountyList: RecyclerView
    private lateinit var countryListAdapter: CountryListAdapter
    var list = mutableListOf<CountryListData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initMethod()
    }

    private fun initMethod() {

        rvCountyList = findViewById(R.id.rvCountyList)
        rvCountyList.layoutManager = LinearLayoutManager(this)

        RestClient.getService().getCountryList().enqueue(responsecallback)

    }

    val responsecallback = object : retrofit2.Callback<List<CountryListData>> {
        override fun onResponse(
            call: Call<List<CountryListData>>,
            response: Response<List<CountryListData>>
        ) {
            if (response.isSuccessful && response.body() != null) {
                list = response!!.body()!! as MutableList<CountryListData>
                rvCountyList.adapter = CountryListAdapter(list)
            }
        }

        override fun onFailure(call: Call<List<CountryListData>>, t: Throwable) {
            Toast.makeText(this@MainActivity, R.string.try_again, Toast.LENGTH_SHORT).show()
        }
    }
}