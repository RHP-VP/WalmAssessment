package com.rp.wmytestapplication.api

import com.rp.wmytestapplication.models.BaseResponse
import com.rp.wmytestapplication.models.CountryListData
import retrofit2.Call
import retrofit2.http.GET

interface AppApi {

    @GET(AppConstants.COUNTRY_LIST_URL)
    fun getCountryList(): Call<List<CountryListData>>
}